package Common.Constant;

import org.openqa.selenium.WebDriver;

/** Shared test configuration. Never commit real credentials. */
public class Constant {
    public static WebDriver WEBDRIVER;

    private static String env(String key, String fallback) {
        String value = System.getenv(key);
        return value == null ? fallback : value;
    }

    public static final String RAILWAY_URL = env(
            "RAILWAY_URL",
            "http://railwayb2.somee.com/Page/SuccessPage.cshtml?id=11182"
    );
    public static final String RAILWAYLOGIN_URL = env(
            "RAILWAY_LOGIN_URL",
            "http://railwayb2.somee.com/Account/Login.cshtml"
    );
    public static final String USERNAME = env("RAILWAY_USERNAME", "");
    public static final String PASSWORD = env("RAILWAY_PASSWORD", "");
    public static final String PASSWORD_WRONG = env(
            "RAILWAY_INVALID_PASSWORD",
            "invalid-password-for-negative-test"
    );
    public static final String NEW_PASSWORD = env("RAILWAY_NEW_PASSWORD", "");
    public static final String PID = env("RAILWAY_TEST_PID", "12345678");
}