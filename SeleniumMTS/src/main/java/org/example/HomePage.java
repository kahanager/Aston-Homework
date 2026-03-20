package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{
    private final By titleLocator = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By phoneFieldLocator = By.id("connection-phone");
    private final By sumFieldLocator = By.id("connection-sum");
    private final By submitButtonLocator = By.xpath(
            "//form[@id='pay-connection']/button[@type='submit']");
    private final By helpLinkLocator = By.xpath(
            "//div[@class='pay__wrapper']/a[@href]");
    private final By cookieButtonLocator = By.xpath(
            "//button[@id='cookie-agree']");
    private final By selectArrowLocator = By.xpath(
            "//span[@class='select__arrow']");

    private final By[] logoLocators = {
            By.xpath("//img[@alt='Visa']"),
            By.xpath("//img[@alt='Verified By Visa']"),
            By.xpath("//div[@class='pay__partners']/ul/li/img[@alt='MasterCard']"),
            By.xpath("//img[@alt='MasterCard Secure Code']"),
            By.xpath("//div[@class='pay__partners']/ul/li/img[@alt='Белкарт']")
    };
    private final  By[] selectOptionLocators = {
             By.xpath(
                     "//p[@class='select__option' and text()='Услуги связи']"),
             By.xpath(
                "//p[@class='select__option' and text()='Домашний интернет']"),
             By.xpath(
                    "//p[@class='select__option' and text()='Рассрочка']"),
             By.xpath(
                    "//p[@class='select__option' and text()='Задолженность']")
    };

    private final By[] fieldsTextLocators = {
            By.id("connection-phone"), //услуги связи
            By.id("internet-phone"),   //домашний интернет
            By.id("score-instalment"),  //рассрочка
            By.id("score-arrears")  //задолжность
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

    public List<By> checkLogos() {
        List<By> missing = new ArrayList<>();
        for (By locator : logoLocators) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                missing.add(locator);
            }
        }
        return missing;
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

    public List<String> checkFieldsText() {
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < selectOptionLocators.length; i++) {
            WebElement linkArrow = wait.until(ExpectedConditions.elementToBeClickable(
                    selectArrowLocator));
            linkArrow.click();
            WebElement linkOptions = wait.until(ExpectedConditions.elementToBeClickable(
                    selectOptionLocators[i]));
            linkOptions.click();
            WebElement linkFields = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    fieldsTextLocators[i]));
            String text = linkFields.getAttribute("placeholder");
            resultList.add(text);
        }
        return resultList;
    }


}
