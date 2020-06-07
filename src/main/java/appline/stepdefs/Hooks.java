package appline.stepdefs;

import appline.PropsSettings;
import appline.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;


public class Hooks {

    @Before
    public void start() {
        Properties properties = PropsSettings.getInstance().getProperties();
        BaseSteps.init();
        BaseSteps.getSite(properties.getProperty("urlSber"));
    }

    @After
    public void quit() {
        BaseSteps.quit();
    }
}
