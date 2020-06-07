package appline.stepdefs;

import appline.steps.MainPageSteps;
import appline.steps.MortgagePageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    private static final MainPageSteps mainPageSteps = new MainPageSteps();
    private static final MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @When("Закрыто окно cookie")
    public void close() {
        mainPageSteps.closeCookie();
    }

    @When("выбираем ипотеку")
    public void goToMortgage(){
       mainPageSteps.goToMortgage();
    }

    @When("переключаемся на нужную страницу")
    public void switchFrame() {
        mortgagePageSteps.switchFrame();
    }

    @When("очищаем поля ввода {string}")
    public void clear (String fieldName) {
        mortgagePageSteps.clear(fieldName);
    }

    @When("поле {string} заполняется значением {string}")
    public void inputValues(String fieldName, String amount) {
        mortgagePageSteps.inputValues(fieldName, amount);
    }

    @When("переключаем свич с порядковым номером {string}")
    public void switchButton(String switchNum) {
        mortgagePageSteps.switchButton(switchNum);
    }

    @Then("проверяем значения {string} с ожидаемым {string}")
    public void checkSum(String title, String expected) {
        mortgagePageSteps.checkSum(title, expected);
    }

    @Then("проверяем процентную ставку с ожидаемой")
    public void checkProc(){
        mortgagePageSteps.checkProc();
    }
}
