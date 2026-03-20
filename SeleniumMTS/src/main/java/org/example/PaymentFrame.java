package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PaymentFrame extends BasePage {
    private final By iframeLocator = By.xpath(
            "//iframe[@class='payment-widget-iframe']");
    private final By sumLocator = By.xpath(
            "//div[@class ='pay-description__cost']/span");
    private final By sumButtonLocator = By.xpath(
            "//button[@class ='colored disabled']/span");
    private final By sumTextLocator = By.xpath(
            "//div[@class ='card-page__agreement ng-star-inserted']/span");
    private final By phoneNumberLocator = By.xpath(
            "//div[@class = 'pay-description__text']/span");

    private final By[] logoLocators = {
            By.xpath("//img[@src='assets/images/" +
                    "payment-icons/card-types/visa-system.svg']"),
            By.xpath("//img[@src= 'assets/images/" +
                    "payment-icons/card-types/mastercard-system.svg']"),
            By.xpath("//img[@src= 'assets/images/" +
                    "payment-icons/card-types/belkart-system.svg']"),
            By.xpath("//img[@src= 'assets/images/" +
                    "payment-icons/card-types/maestro-system.svg']"),
            By.xpath("//img[@src= 'assets/images/" +
                    "payment-icons/card-types/mir-system-ru.svg']")
    };

    private final By[] fieldsTextLocators = {
            By.xpath("//label[@class = 'ng-tns-c2312288139-2 ng-star-inserted']"), //номер карты
            By.xpath("//label[@class = 'ng-tns-c2312288139-4 ng-star-inserted']"),   //срок действия
            By.xpath("//label[@class = 'ng-tns-c2312288139-5 ng-star-inserted']"),  //CVV
            By.xpath("//label[@class = 'ng-tns-c2312288139-3 ng-star-inserted']")  //Имя
    };

    public PaymentFrame(WebDriver driver) {
        super(driver);
    }

    private void switchToFrame() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframe);
    }

    private void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public String getIframeSrc() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        return iframe.getAttribute("src");
    }

    public String getTitlePaySum() {
        switchToFrame();
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumLocator)).getText();
        } finally {
            switchToDefault();
        }
    }

    public String getButtonPaySum() {
        switchToFrame();
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumButtonLocator)).getText();
        } finally {
            switchToDefault();
        }
    }

    public String getTextPaySum() {
        switchToFrame();
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumTextLocator)).getText();
        } finally {
            switchToDefault();
        }
    }

    public String getPhoneNumber() {
        switchToFrame();
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberLocator)).getText();
        } finally {
            switchToDefault();
        }
    }

    public List<By> checkLogos() {
        switchToFrame();
        List<By> missing = new ArrayList<>();
        try {
            for (By locator : logoLocators) {
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                } catch (Exception e) {
                    missing.add(locator);
                }
            }
        } finally {
            switchToDefault();
        }
        return missing;
    }

    public List<String> checkFieldsText() {
        switchToFrame();
        List<String> resultList = new ArrayList<>();
        try {
            for (By locator : fieldsTextLocators) {
                try {
                    WebElement linkFields = wait.until(
                            ExpectedConditions.visibilityOfElementLocated(locator));
                    String text = linkFields.getText();
                    resultList.add(text);
                } catch (Exception e) {
                    // Если элемент не найден, добавляем пустую строку, чтобы сохранить порядок
                    System.out.println("Не удалось получить текст для локатора: " + locator);
                }
            }
        } finally {
            switchToDefault();
        }
        return resultList;
    }

}