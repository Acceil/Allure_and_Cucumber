package appline.pages;

import appline.stepdefs.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appline.stepdefs.BaseSteps.getDriver;

public class BasePage {
    WebDriverWait wait = BaseSteps.webDriverWait;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void moveToElement(WebElement webElement) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement).perform();
    }

    public void doubleClick(WebElement webElement) {
        Actions actions = new Actions(getDriver());
        actions.doubleClick(webElement).perform();
    }

    public void customWait(WebElement element, String value) {
        waitUntilVisible(element);
        wait.until(webDriver -> {
            String currentValue = element.getText();
            return !currentValue.equals(value);
        });
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void switchToFrame(WebElement element) {
        getDriver().switchTo().frame(element);
    }

}
