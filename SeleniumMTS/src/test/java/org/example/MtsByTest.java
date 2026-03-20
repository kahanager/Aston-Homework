package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTest {
    private WebDriver driver;
    private HomePage homePage;


    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        homePage = new HomePage(driver);

        homePage.cookieClose();
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }

    @Test
    public void testName() {
        String actualText = homePage.getTitleText();
        String expectedText = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void testFieldsText() {

    }

    @Test
    public void testLogosHomePage() {
        List<By> missing = homePage.checkLogos();
        assertTrue(missing.isEmpty(),
                "Отсутствуют логотипы: " + missing);
    }

    @Test
    public void testLink() {
        HelpPage helpPage = homePage.clickServiceLink();
        String currentUrl = helpPage.getCurrentUrl();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, currentUrl, "URL после перехода не совпадает");
    }

    @Test
    public void testPayment() {
        PaymentFrame paymentFrame = homePage.proceedPayment("297777777", "499");
        String actualSrc = paymentFrame.getIframeSrc();
        String expectedSrc = "https://checkout.bepaid.by/widget_v2/index.html";
        assertEquals(expectedSrc, actualSrc, "Атрибут src iframe не соответствует ожидаемому");
    }

    @Test
    public void testTextFields() {
        List<String> actualText = homePage.checkFieldsText();
        List<String> expectedText = List.of(
                "Номер телефона", "Номер абонента", "Номер счета на 44", "Номер счета на 2073");
        assertEquals(expectedText, actualText);
    }
    @Test
    public void testPaySum() {
        PaymentFrame paymentFrame = homePage.proceedPayment("297777777", "499");
        String paySum = "499";
        String titleSum = paymentFrame.getTitlePaySum();
        String buttonSum = paymentFrame.getButtonPaySum();
        String textSum = paymentFrame.getTextPaySum();
        assertTrue(titleSum.contains(paySum + " ") || titleSum.contains(paySum + ".00"));
        assertTrue(buttonSum.contains(" " + paySum + " ") || buttonSum.contains(" " + paySum + ".00"));
        assertTrue(textSum.contains(" " + paySum + " ") || textSum.contains(" " + paySum + ".00"));
    }
    @Test
    public void testPhoneNumber() {
        PaymentFrame paymentFrame = homePage.proceedPayment("297777777", "499");
        String expectedNumber = "375297777777";
        String actualNumber = paymentFrame.getPhoneNumber();
        assertTrue(actualNumber.contains(expectedNumber));
    }
    @Test
    public void testLogosPaymentPrame() {
        PaymentFrame paymentFrame = homePage.proceedPayment("297777777", "499");
        List<By> missing = paymentFrame.checkLogos();
        assertTrue(missing.isEmpty(),
                "Отсутствуют логотипы: " + missing);
    }
    @Test
    public void testTextFieldsPaymentPrame() {
        PaymentFrame paymentFrame = homePage.proceedPayment("297777777", "499");
        List<String> actualText = paymentFrame.checkFieldsText();
        List<String> expectedText = List.of(
                "Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте");
        assertEquals(expectedText, actualText);
    }

}
