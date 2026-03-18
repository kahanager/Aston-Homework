package org.example;
import org.openqa.selenium.WebDriver;

public class HelpPage extends BasePage {
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}