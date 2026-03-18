package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private final By titleLocator = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By phoneFieldLocator = By.id("connection-phone");
    private final By sumFieldLocator = By.id("connection-sum");
    private final By submitButtonLocator = By.xpath("//form[@id='pay-connection']/button[@type='submit']");
    private final By helpLinkLocator = By.xpath("//div[@class='pay__wrapper']/a[@href]");
    private final By cookieButtonLocator = By.xpath("//button[@id='cookie-agree']");

    private final By[] logoLocators = {
            By.xpath("//img[@alt='Visa']"),
            By.xpath("//img[@alt='Verified By Visa']"),
            By.xpath("//div[@class='pay__partners']/ul/li/img[@alt='MasterCard']"),
            By.xpath("//img[@alt='MasterCard Secure Code']"),
            By.xpath("//div[@class='pay__partners']/ul/li/img[@alt='Белкарт']")
    };

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void cookieClose() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator)).click();
        } catch (Exception e) {
            System.out.println("Cookie-баннер не найден или уже закрыт");
        }
    }

    public String getTitleText() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return titleElement.getText();
    }

    public void checkLogos() {
        for (By locator : logoLocators) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                System.out.println("Логотип не найден: " + locator + " – " + e.getClass().getSimpleName());
            }
        }
    }

    public HelpPage clickServiceLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(helpLinkLocator));
        link.click();
        return new HelpPage(driver);
    }

    public PaymentFrame proceedPayment(String phone, String sum) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFieldLocator)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sumFieldLocator)).sendKeys(sum);
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator)).click();
        return new PaymentFrame(driver);
    }
}
