package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    private static final String WEB_DRIVER_WINDOWS_POSTFIX = ".exe";

    /**
     * Method which opens a browser by passed browserType.
     * <p>
     * Valid options: chrome, firefox, opera
     *
     * @param browserType the browser type which will be opened.
     * @param isWindows "true" if the operating system is Windows; "false" if it is macOS
     */
    public static void open(String browserType, boolean isWindows) {
        switch (browserType) {
            case "chrome":
                System.setProperty(
                        "webdriver.chrome.driver",
                        "src/test/resources/chromedriver"
                                + (isWindows ? ".exe" : "")
                );
                driver = new ChromeDriver();
                break;
            case "firefox":
                break;
            case "opera":
                break;

            default:
                throw new RuntimeException("The browser that is chosen " + browserType + " is not a valid browser!");
        }
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));
        driver.manage().window().maximize();

    }

    /**
     * Opens the url page in browser
     * @param url the address of the page
     */
    public static void goToPage(String url) {
        driver.get(url);
    }

    /**
     * Method which closes the browser.
     */
    public static void quit() {
        driver.quit();
    }

}
