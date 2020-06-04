import appline.steps.MainPageSteps;
import appline.steps.MortgagePageSteps;
import org.junit.jupiter.api.Test;

public class AllureSberTest extends PapaTest {

    @Test
    public void mainTest() throws InterruptedException {
        MainPageSteps mainPageSteps = new MainPageSteps();
        MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

        mainPageSteps.goToMortgage();

        mortgagePageSteps.switchFrame();
        mortgagePageSteps.clear("Стоимость недвижимости");
        mortgagePageSteps.inputValues("Стоимость недвижимости", "5 180 000");
        mortgagePageSteps.clear("Первоначальный взнос");
        mortgagePageSteps.inputValues("Первоначальный взнос", "3 058 000");
        mortgagePageSteps.clear("Срок кредита");
        mortgagePageSteps.inputValues("Срок кредита", "30");

        mortgagePageSteps.switchButton("2");
        mortgagePageSteps.switchButton("3");
        mortgagePageSteps.switchButton("6");

        mortgagePageSteps.checkSum();

    }
}
