package helper;

import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;

public class DataProviders
{

    @DataProvider(name = "PositivePages")
    public static Object[][] positivePages()
    {
        return new Object[][]{
                {0, 10}, {1, 10}, {11, 10}, {31, 10}, {42, 10}
        };
    }

    @DataProvider(name = "NegativeOneParameter")
    public static Object[][] negativeOneParameter()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeOneParameterImo")
    public static Object[][] negativeOneParameterImo()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_IMO.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.LARGE_IMO.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeTwoParameter")
    public static Object[][] negativeTwoParameter()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeTwoParameterAssets")
    public static Object[][] negativeTwoParameterAssets()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND_FOR_ASSET_ITEM.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND_FOR_ASSET.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeTwoParameterDefects")
    public static Object[][] negativeTwoParameterDefects()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND_FOR_REPAIR.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND_FOR_DEFECT.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeTwoParameterJobs")
    public static Object[][] negativeTwoParameterJobs()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND_FOR_REPORT.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND_FOR_JOB.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeTwoParameterGeneric")
    public static Object[][] negativeTwoParameterGeneric()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.COMBINATION_NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeThreeParameter")
    public static Object[][] negativeThreeParameter()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.NOT_FOUND.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeForPages")
    public static Object[][] negativeTwoParameterForPages()
    {
        return new Object[][]{
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.TEST.getParameter(),
                        Parameter.TEST.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.TEST_INVALID.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.MINUS_NUMBER.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.MINUS_NUMBER_INVALID.getMessage()
                },
                {
                        Parameter.NULL_VALUE.getParameter(),
                        Parameter.NULL_VALUE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.NULL_PAGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.TEST.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.TEST_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.MINUS_NUMBER_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.NULL_VALUE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.NULL_PAGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "NegativeTwoParameterPages")
    public static Object[][] negativeTwoParameterPages()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                };
    }

    @DataProvider(name = "NegativeForPagesWithId")
    public static Object[][] negativeTwoParameterForPagesWithId()
    {
        return new Object[][]{
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage(),
                        },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.TEST.getParameter(),
                        Parameter.TEST.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.TEST_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.MINUS_NUMBER_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.TEST.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.TEST_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.MINUS_NUMBER_INVALID.getMessage()
                },
                };
    }

    @DataProvider(name = "NegativeForPagesWithIdAnd422Responses")
    public static Object[][] negativeTwoParameterForPagesWithIdAnd422Responses()
    {
        return new Object[][]{
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage(),
                        },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.TEST.getParameter(),
                        Parameter.TEST.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.TEST_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.TEST.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.TEST_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.MINUS_NUMBER.getParameter(),
                        HttpStatus.SC_UNPROCESSABLE_ENTITY,
                        ErrorMessage.PAGE_ZERO_OR_LESS.getMessage()
                },
                };
    }

    @DataProvider(name = "NegativeAttributeThreeParameter")
    public static Object[][] negativeAttributeThreeParameter()
    {
        return new Object[][]{
                {
                        Parameter.NOT_FOUND.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_NOT_FOUND,
                        ErrorMessage.ATTRIBUTE_NOT_FOUND.getMessage()
                },
                {
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ZERO.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ZERO_INVALID.getMessage()
                },
                {
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        Parameter.ONE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                },
                {
                        Parameter.ONE.getParameter(),
                        Parameter.ONE.getParameter(),
                        Parameter.ID_TOO_LARGE.getParameter(),
                        HttpStatus.SC_BAD_REQUEST,
                        ErrorMessage.ID_TOO_LARGE_INVALID.getMessage()
                }
        };
    }

    @DataProvider(name = "Asset")
    public Object[][] assets()
    {
        return new Object[][]{
                {1},
                {3},
                {419},
                {401}
        };
    }

    private enum Parameter
    {

        TEST("TEST"),
        NOT_FOUND("50000"),
        ZERO("0"),
        ID_TOO_LARGE("10000000000"),
        MINUS_NUMBER("-1"),
        NULL_VALUE(" "),
        ONE("1");

        private String parameter;

        Parameter(String parameter)
        {
            this.parameter = parameter;
        }

        public String getParameter()
        {
            return parameter;
        }
    }

    private enum ErrorMessage
    {

        TEST_INVALID("Could not bind parameter " + Parameter.TEST.getParameter() + " to number."),
        NOT_FOUND("Entity not found for identifier: " + Parameter.NOT_FOUND.getParameter() + "."),
        ZERO_INVALID("Parameter with invalid type: " + Parameter.ZERO.getParameter() + " is not a valid ID"),
        ID_TOO_LARGE_INVALID("Parameter with invalid type: " + Parameter.ID_TOO_LARGE.getParameter() + " is not a valid ID"),
        MINUS_NUMBER_INVALID("Parameter with invalid type: " + Parameter.MINUS_NUMBER.getParameter() + " is not a valid ID"),
        NULL_PAGE_INVALID("Could not bind parameter " + Parameter.NULL_VALUE.getParameter() + " to number."),
        PAGE_ZERO_OR_LESS("Cannot request a page with a size of " + Parameter.ZERO.getParameter() + " or less."),
        ATTRIBUTE_NOT_FOUND("Attribute with identifier " + Parameter.ONE.getParameter() + " not found for asset "
                + Parameter.NOT_FOUND.getParameter() + ", item " + Parameter.ONE.getParameter() + "."),
        NOT_FOUND_FOR_ASSET_ITEM(
                "Item with identifier " + Parameter.ONE.getParameter() + " not found for asset " + Parameter.NOT_FOUND.getParameter()),
        NOT_FOUND_FOR_ASSET("Report with identifier " + Parameter.NOT_FOUND.getParameter() + " not found for asset " + Parameter.ONE.getParameter()),
        NOT_FOUND_FOR_REPORT("Report with identifier " + Parameter.ONE.getParameter() + " not found for job " + Parameter.NOT_FOUND.getParameter()),
        NOT_FOUND_FOR_JOB("Report with identifier " + Parameter.NOT_FOUND.getParameter() + " not found for job " + Parameter.ONE.getParameter()),
        NOT_FOUND_FOR_REPAIR(
                "Repair with identifier " + Parameter.ONE.getParameter() + " not found for defect " + Parameter.NOT_FOUND.getParameter()),
        NOT_FOUND_FOR_DEFECT(
                "Repair with identifier " + Parameter.NOT_FOUND.getParameter() + " not found for defect " + Parameter.ONE.getParameter()),
        COMBINATION_NOT_FOUND("Entity combination not found."),
        LARGE_IMO("Parameter with invalid type: " + Parameter.ID_TOO_LARGE.getParameter() + " is not a valid IMO Number"),
        ZERO_IMO("Parameter with invalid type: " + Parameter.ZERO.getParameter() + " is not a valid IMO Number");

        private String message;

        ErrorMessage(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }
    }
}
