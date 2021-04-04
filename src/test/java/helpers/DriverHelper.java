package helpers;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {
    public static void configureDriver() {
        Configuration.baseUrl = ConfigHelper.getWebUrl();//"https://ifellow.ru/";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;

        if (ConfigHelper.isRemoteWebDriver()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getWebRemoteDriver();
        }
    }
}
