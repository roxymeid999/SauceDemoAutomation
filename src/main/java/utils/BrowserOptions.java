package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BrowserOptions {

    public static ChromeOptions getOptions() {

            ChromeOptions options = new ChromeOptions();


            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);


            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-features=PasswordManagerOnboarding,AutofillServerCommunication");
            options.addArguments("--disable-sync");


            options.addArguments("--incognito");

            return options;
        }
}