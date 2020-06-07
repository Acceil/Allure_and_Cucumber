package appline.steps;

import appline.pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {

    @Step("Закрытие Cookie")
    public void closeCookie() {
        MainPage mainPage = new MainPage();
        mainPage.checkCookie();
    }

    @Step("выбираем ипотеку")
    public void goToMortgage(){
        MainPage mainPage = new MainPage();
        mainPage.goToMortgage();
    }
}
