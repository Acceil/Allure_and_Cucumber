package appline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static appline.stepdefs.BaseSteps.getDriver;

public class ContributionsPage extends BasePage {
    private static final String currency = "//span[contains(text(), '%s')]";

    @FindBy(xpath = "(//div[@class='calculator__check-row'])[2]//div[@class='jq-checkbox calculator__check checked']")
    WebElement checkedCheckBox;

    @FindBy(xpath = "//div[contains(text(), 'месяц')]")
    WebElement monthList;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement amount;

    @FindBy(xpath = "//input[@name='replenish']")
    WebElement replenish;

    @FindBy(xpath = "(//div[@class='jq-checkbox calculator__check'])[2]")
    WebElement checkBox;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement earned;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenished;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement result;

    public void chooseCurrency(String currencyName) {
        By locator = By.xpath(String.format(currency, currencyName));
        WebElement currencyEl = getDriver().findElement(locator);
        moveToElement(currencyEl);
        doubleClick(currencyEl);
    }

    public void input(String fieldName, String value) {
        switch (fieldName) {
            case "Сумма вклада":
                input(amount, value);
                break;

            case "На срок":
                monthList.click();
                monthList.findElement(By.xpath("//ul/li[contains(text(), '" + value + "')]")).click();
                break;

            case "Ежемесячное пополнение":
                input(replenish, value);
                break;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    private void input(WebElement field, String value) {
        moveToElement(field);
        waitUntilClickable(field).click();
        field.sendKeys(value);
        customWait(field, value);
    }

    public String getValues(String fieldName) {
        switch (fieldName) {
            case "Начислено %":
                return earned.getText();

            case "Пополнение за 9 месяцев":
                return replenished.getText();

            case "К снятию через 9 месяцев":
                return result.getText();
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void selectCheckBox() {
        waitUntilClickable(checkBox).click();
//        waitUntilVisible(checkedCheckBox);
        sleep(1500);
    }
}
