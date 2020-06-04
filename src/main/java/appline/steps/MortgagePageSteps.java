package appline.steps;

import appline.pages.MortgagePage;
import appline.utils.AllureUtils;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;


public class MortgagePageSteps {
    private static final MortgagePage mortgagePage = new MortgagePage();

    @Step("Переключаемся на нужную страницу")
    public void switchFrame() {
        mortgagePage.switchToFrame();
    }

    @Step("Очищаем поля ввода {fieldName}")
    public void clear(String fieldName) {
        mortgagePage.clearInput(fieldName);
    }

    @Step("Поле {fieldName} замолняется значением {amount}")
    public void inputValues(String fieldName, String amount) {
        AllureUtils.takeScreenshot();
        mortgagePage.input(fieldName, amount);
    }

    @Step("Переключаем свич с порядковым номером {switchNum}")
    public void switchButton(String switchNum) {
        AllureUtils.takeScreenshot();
        mortgagePage.setSwitchControl(switchNum);
    }

    @Step("Проверяем значения с ожидаемыми")
    public void checkSum() {
        assertThat("Значения не равны!", mortgagePage.checkSum("Сумма кредита", "2 122 000 ₽"));
        assertThat("Значения не равны!", mortgagePage.checkSum("Ежемесячный платеж", "16 922 ₽"));
        assertThat("Значения не равны!", mortgagePage.checkSum("Необходимый доход", "28 203 ₽"));
        assertFalse("Значения не равны!", mortgagePage.checkSum("Процентная ставка", "11 %"));
    }
}
