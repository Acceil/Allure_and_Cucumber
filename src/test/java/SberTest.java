import appline.pages.MainPage;
import appline.pages.MortgagePage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SberTest extends PapaTest {

    @Test
    public void mainTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.goToMortgage();

        MortgagePage mortgagePage = new MortgagePage();
        mortgagePage.switchToFrame();
        mortgagePage.clearInput("Стоимость недвижимости"); // сначала чищу
        mortgagePage.input("Стоимость недвижимости", "5 180 000"); // потом заполняю
        mortgagePage.clearInput("Первоначальный взнос");
        mortgagePage.input("Первоначальный взнос", "3 058 000");
        mortgagePage.clearInput("Срок кредита");
        mortgagePage.input("Срок кредита", "30");
        mortgagePage.setSwitchControl("2");//второй переключатель (1 кнопка в задании)
        mortgagePage.setSwitchControl("3");//третий переключатель (2 кнопка)
        mortgagePage.setSwitchControl("6");//шестой переключатель (крайняя кнопка)
        assertThat("Значения не равны!", mortgagePage.checkSum("Сумма кредита", "2 122 000 ₽"));
        assertThat("Значения не равны!", mortgagePage.checkSum("Ежемесячный платеж", "16 922 ₽"));
        assertThat("Значения не равны!", mortgagePage.checkSum("Необходимый доход", "28 203 ₽"));
        assertFalse(mortgagePage.checkSum("Процентная ставка", "11 %"), "Значения не равны!");

    }


}
