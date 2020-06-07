package appline.pages;

import appline.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Ипотека')]")
    WebElement toMortgage;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']//a[text() = 'Ипотека на готовое жильё']")
    WebElement clickMortgage;

    @FindBy(xpath = "//a[@class='cookie-warning__close']")
    WebElement cookie;


    public void checkCookie() {
        if (!BaseSteps.getDriver()
                .findElements(By.xpath("//div[@class='cookie-warning cookie-warning_show']"))
                .isEmpty()) {
            cookie.click();
        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void goToMortgage() {
        moveToElement(toMortgage);
        waitUntilClickable(clickMortgage).click();
    }
}
