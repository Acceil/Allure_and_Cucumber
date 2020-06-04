package appline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgagePage extends BasePage {
    private static final String propertyPrice = "//div[./div[contains(text(), '%s')]]//input";
    private static final String switchControl = "(//span[@class='dcCalc_switch__control'])[%s]";
    private static final String money = "//div[./div[contains(text(), '%s')]]//span";

    @FindBy(xpath = "//div//iframe")
    WebElement iframe;

    public void switchToFrame() {
        switchToFrame(iframe);
    }

    public void clearInput(String fieldName) {
        By locator = By.xpath(String.format(propertyPrice, fieldName));
        WebElement price = driver.findElement(locator);
        customWait();
        moveToElement(price);
        waitUntilClickable(price);
        price.click();
        waitUntilClickable(price).sendKeys(Keys.chord(Keys.CONTROL, "a"));// выделяю весь текст
        waitUntilClickable(price).clear();
    }

    public void setSwitchControl(String switchNum) {
        By locator = By.xpath(String.format(switchControl, switchNum));
        WebElement switchButton = driver.findElement(locator);
        customWait();
        moveToElement(switchButton); //двигаем к элементу
        waitUntilClickable(switchButton); //ждем кликабельности
        switchButton.click(); //кликаем
    }

    public void input(String fieldName, String amount) {
        By locator = By.xpath(String.format(propertyPrice, fieldName));
        WebElement price = driver.findElement(locator);
        moveToElement(price);
        waitUntilClickable(price).sendKeys(amount);
    }

    public boolean checkSum(String calculationTitle, String expected) throws InterruptedException {
        Thread.sleep(500);
        By locator = By.xpath(String.format(money, calculationTitle));
        WebElement cash = driver.findElement(locator);
        return cash.getText().equals(expected);
    }
}
