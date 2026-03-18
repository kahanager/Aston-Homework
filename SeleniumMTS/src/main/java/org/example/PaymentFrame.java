package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentFrame extends BasePage {
    private final By iframeLocator = By.xpath("//iframe[@class='payment-widget-iframe']");

    public PaymentFrame(WebDriver driver) {
        super(driver);
    }

    public String getIframeSrc() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        return iframe.getAttribute("src");
    }
}