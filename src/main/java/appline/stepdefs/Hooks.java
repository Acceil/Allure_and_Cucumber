package appline.stepdefs;

import appline.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void start() {
        BaseSteps.init();
        BaseSteps.getSite("https://www.sberbank.ru/ru/person?utm_source=ep");
    }

    @After
    public void quit() {
        BaseSteps.quit();
    }
}
