package appline.steps;

import appline.PropsSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    public static WebDriverWait webDriverWait;
    private static final ChromeOptions options = new ChromeOptions();
    public static Actions actions;

    public static void init() {
        Properties properties = PropsSettings.getInstance().getProperties();

        String browser = properties.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                System.setProperty(properties.getProperty("chromeDriver"), properties.getProperty("driverPathChrome"));
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(properties.getProperty("firefoxDriver"), properties.getProperty("driverPathFirefox"));
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
    }

    @Step("Заходим на сайт {url}")
    public static void getSite(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
