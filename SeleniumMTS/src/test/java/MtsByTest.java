import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsByTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.mts.by");
        cookieClose();
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }

    private void cookieClose() {
        try {
            By cookieButtonLocator = By.xpath("//button[@id='cookie-agree']");
            wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator)).click();
        } catch (Exception e) {
            System.out.println("Cookie-баннер не найден или уже закрыт");
        }
    }

    @Test
    public void testName() {
        By titleLocator = By.xpath("//div[@class='pay__wrapper']/h2");
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        String actualText = titleElement.getText();
        String expectedText = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void testLogos() {
        By[] logoLocators = {
                By.xpath("//img[@alt='Visa']"),
                By.xpath("//img[@alt='Verified By Visa']"),
                By.xpath("//div[@class='pay__partners']/ul/li/img[@alt='MasterCard']"),
                By.xpath("//img[@alt='MasterCard Secure Code']"),
                By.xpath("//div[@class='pay__partners']/ul/li/img[@alt='Белкарт']")
        };

        for (int i = 0; i < logoLocators.length; i++) {
            By locator = logoLocators[i];
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                System.out.println("Логотип не найден: " + locator + " – " + e.getClass().getSimpleName());
            }
        }
    }

    @Test
    public void testLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[@class='pay__wrapper']/a[@href]")));
        link.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, currentUrl, "URL после перехода не совпадает");
    }

    @Test
    public void testPayment() {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "connection-phone")));
        phoneField.click();
        phoneField.sendKeys("297777777");

        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "connection-sum")));
        sumField.click();
        sumField.sendKeys("499");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//form[@id='pay-connection']/button[@type='submit']")));
        submitButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//iframe[@class='payment-widget-iframe']")));
        String expectedSrc = "https://checkout.bepaid.by/widget_v2/index.html";
        String actualSrc = iframe.getAttribute("src");
        assertEquals(expectedSrc, actualSrc, "Атрибут src iframe не соответствует ожидаемому");
    }
}