package helper;

import com.google.common.io.Resources;
import org.testng.Assert;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.*;

public class DatabaseHelper
{

    private static String dbUser = "testUser";
    private static String dbPassword = "s3curePa55word";

    static {
        if (System.getProperty("dbUser") != null) {
            dbUser = System.getProperty("dbUser");
        }
        if (System.getProperty("dbPassword") != null) {
            dbPassword = System.getProperty("dbPassword");
        }
    }

    public static ResultSet executeQuery(String sql)
    {
        return executeQuery(sql, Database.MAST);
    }

    public static void insertQuery(String sql)
    {
        insertQuery(sql, Database.MAST);
    }

    public static ResultSet executeQuery(String sql, Database database)
    {
        try
        {
            return database.getCon().createStatement().executeQuery(sql);
        }
        catch (SQLException e)
        {
            Assert.fail("Test Failed due to SQL Error: " + e.toString());
        }
        return null;
    }

    public static void insertQuery(String sql, Database database)
    {
        try
        {
            Statement statement = database.getCon().createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        }
        catch (SQLException e)
        {
            Assert.fail("Test Failed due to SQL Error: " + e.toString());
        }
    }

    public static int getRowCount(ResultSet resultSet)
    {
        int rowCount = 0;
        try
        {
            if (resultSet.last())
            {
                rowCount = resultSet.getRow();
                resultSet.beforeFirst();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static void runSqlFile(String resourceFilePath, String... values)
    {
        runSqlFile(resourceFilePath, Database.MAST, values);
    }

    public static void runSqlFile(String resourceFilePath, Database database, String... values)
    {
        URL sqlFileURL = Resources.getResource(resourceFilePath);
        ScriptRunner scriptRunner = new ScriptRunner(database.getCon(), false, true);
        try
        {
            String sqlScript =
                    String.format(Resources.toString(sqlFileURL, Charset.defaultCharset()), (Object[]) values);
            scriptRunner.runScript(new StringReader(sqlScript));
        }
        catch (IOException | SQLException e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public enum Database
    {

        IHS("ihs_db"),
        MAST("mast_db");

        private Connection con;

        Database(String db)
        {
            String dbNumber = System.getProperty("dbNumber");
            String dbHost = "localhost";
            Integer dbPort = 3306;
            if (System.getProperty("dbURL") != null)
            {
                try
                {
                    URL dbURL = new URL(System.getProperty("dbURL"));
                    dbHost = dbURL.getHost();
                    dbPort = dbURL.getPort();
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                con = DriverManager.getConnection(
                        "jdbc:mysql://" + dbHost + ":" + dbPort + "/" +
                                db + ((dbNumber != null) ? dbNumber : "") + "?characterEncoding=utf-8",
                        dbUser,
                        dbPassword
                );
            }
            catch (SQLException e)
            {
                Assert.fail(String.format("Failed to setup db connection, reason: %s", e.getMessage()));
            }
        }

        public Connection getCon()
        {
            return con;
        }
    }

}
