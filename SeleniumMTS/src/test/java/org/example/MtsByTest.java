package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testLogos() {
        homePage.checkLogos();
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
}