package helper;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.*;

public final class SignUtils
{
    private static final String PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----" + '\n'
            + "MIICXgIBAAKBgQCeINOcF8PowseGWV3xrkoXqMvx1xLOHD+bQaxNTCYar90Kw+Cw" + '\n'
            + "aVyND0ZYmbSZjL2rQtypPA2ApAoXgwAkuEkvDwgfFCEPFHu6AD14RJDSY5zIVZOB" + '\n'
            + "EXYg9tYsoToczth9gykjbHzfVuUvbjU+Zsvc6wEs9sdPj82BQ8vax8jyxQIDAQAB" + '\n'
            + "AoGARqWj5Tk47eUX/44tyqxzrd5cP9A3Np6oTFUrBd3fqEyqFQUufaKVFvCcHTmO" + '\n'
            + "1otqsflNXM7XuYGQgLCmf8FV8FyUFJke5fMQbTyy/OjRUGRUtinduNBj7rt3wNaq" + '\n'
            + "vg/NOigis4xszuZvw/QOae8gtziZTtgpGDpVBHreFCDpCAECQQDNk2H2qtysUyVz" + '\n'
            + "KzB3PLkW/E4X/tWWLjct9tF/CpBOPnUgJDmWMT224IOW0NlSXmUVVfmSl2u4bzFI" + '\n'
            + "f4+xBhYVAkEAxOoYxJm8vdsUBEGekiuXAv/uXL4N11uBbnJGBhs5LNktIZPrYi7a" + '\n'
            + "z99elpohZOlbE1seQUjtUup+SVWsvdDF8QJBAIHTTc6lYO9DIyd0YwsqQgmOFRN6" + '\n'
            + "UBCj5x0T/oGofjGrp/RAbE25kyvm5bNc+aHXEydCQHafQdwb/Je4V1qIaXECQQCa" + '\n'
            + "ffg0t1Gnuyx3MmyQzfZK+jUvOkVtw3NHDgz2WYGAOFv6Ti2M+KngEaYKjp7Ip3U3" + '\n'
            + "OHQCUI8yUJwIOVmwCw5hAkEAtQKt0RWImXrV4SqPpjker1ib221mnCREdZMOvMB5" + '\n'
            + "5i6LYG2M104REF+psYQkm4/VgBSUcv5vBVehvTQ53fqZGg==" + '\n'
            + "-----END RSA PRIVATE KEY-----";

    private SignUtils()
    {

    }

    public static String getClientID()
    {
        return "integration-test";
    }

    public static String generateChecksum(final String method, final String url, final String payload)
    {
        return generateChecksum(method, url, payload, PRIVATE_KEY);
    }

    public static String generateChecksum(final String method, final String url, final String payload, final String key)
    {
        final String encodedString = encode(url);

        char[] checksum = new char[0];
        if (encodedString.indexOf("/api") >= 0)
        {

            String urlKey = method + ":" + encodedString;
            if (payload != null && payload.length() > 0)
            {
                urlKey += "[";
                urlKey += payload;
                urlKey += "]";
            }

            Signature verifier = null;
            try
            {
                verifier = Signature.getInstance("SHA256withRSA");
            }
            catch (final NoSuchAlgorithmException exception)
            {
                throw new RuntimeException("getResponse", exception);
            }

            PrivateKey privateKey = null;
            try
            {
                privateKey = readPrivateKey(key);
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                verifier.initSign(privateKey);
            }
            catch (final InvalidKeyException e)
            {
                e.printStackTrace();
            }
            try
            {
                verifier.update(urlKey.getBytes("utf-8"));
            }
            catch (final SignatureException exception)
            {
                throw new RuntimeException("getResponse", exception);
            }
            catch (final UnsupportedEncodingException exception)
            {
                throw new RuntimeException("getResponse", exception);
            }

            try
            {
                checksum = Hex.encodeHex(verifier.sign());
            }
            catch (final SignatureException exception)
            {
                throw new RuntimeException("getResponse", exception);

            }
        }
        return new String(checksum) + "=";

    }

    private static PrivateKey readPrivateKey(final String keyFile) throws IOException
    {
        PrivateKey publicKey = null;
        try (final StringReader reader = new StringReader(keyFile))
        {
            try (final PEMParser pemParser = new PEMParser(reader))
            {
                final PEMKeyPair privateKeyInfo = (PEMKeyPair) pemParser.readObject();

                // Convert to Java (JCA) format
                final JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
                publicKey = converter.getPrivateKey(privateKeyInfo.getPrivateKeyInfo());

            }
        }
        return publicKey;
    }

    private static String encode(final String encode)
    {
        String result;
        final int paramsIndex = encode.indexOf('?');
        if (paramsIndex > 0)
        {
            result = encode.substring(0, paramsIndex);
            final String params = encode.substring(paramsIndex + 1);
            final String[] query = params.split("&");

            int i = 0;
            for (final String queryValue : query)
            {
                result += (i == 0) ? "?" : "&";
                result += encodeParam(queryValue);
                i++;
            }
        }
        else
        {
            result = encode;
        }
        return result;
    }

    private static String encodeParam(final String input)
    {
        final int base = 16;
        final StringBuilder resultStr = new StringBuilder();
        for (final char ch : input.toCharArray())
        {
            if (isUnsafe(ch))
            {
                resultStr.append('%');
                resultStr.append(toHex(ch / base));
                resultStr.append(toHex(ch % base));
            }
            else
            {
                resultStr.append(ch);
            }
        }
        return resultStr.toString();
    }

    private static char toHex(final int ch)
    {
        final int asciiCode = 10;
        return (char) (ch < asciiCode ? '0' + ch : 'A' + ch - asciiCode);
    }

    private static boolean isUnsafe(final char ch)
    {
        final int asciiCode = 128;
        boolean result = false;
        if (ch > asciiCode || ch < 0)
        {
            result = true;
        }
        else
        {
            result = " !%$&+,/:;?@<>#%".indexOf(ch) >= 0;
        }
        return result;
    }
}
