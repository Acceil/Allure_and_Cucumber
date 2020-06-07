package appline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Ипотека')]")
    WebElement toMortgage;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']//a[text() = 'Ипотека на готовое жильё']")
    WebElement clickMortgage;

    public void goToMortgage() {
        moveToElement(toMortgage);
        waitUntilClickable(clickMortgage).click();
    }
}
