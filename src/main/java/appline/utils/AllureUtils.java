package appline.utils;

import appline.steps.BaseSteps;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureUtils {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
