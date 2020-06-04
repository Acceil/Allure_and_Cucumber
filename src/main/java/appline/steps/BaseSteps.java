package appline.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    private static final ChromeOptions options = new ChromeOptions();
    public static Actions actions;

    public static void init() {
        String browser = System.getProperty("webbrowser", "chrome");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 20);
        actions = new Actions(webDriver);
    }

    @Step("Заходим на сайт {url}")
    public static void getSite(String url) {
        webDriver.get(url);
    }

    public static void quit() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
