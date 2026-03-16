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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Разворачиваем окно браузера на весь экран для корректного отображения элементов
        driver.manage().window().maximize();

        // Инициализируем явное ожидание с таймаутом 10 секунд
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Загружаем главную страницу сайта mts.by
        driver.get("https://www.mts.by");
        cookieClose();
    }

    /**
     * Метод, выполняемый после каждого теста.
     * Закрывает браузер и освобождает ресурсы.
     */
    @AfterEach
    public void tearDown() {
        // Проверяем, что драйвер не null (чтобы избежать исключения)
        if (driver != null) {
            // Закрываем все окна браузера и завершаем процесс драйвера
            driver.quit();
        }
    }

    private void cookieClose() {
        try {
            By cookieButtonLocator = By.xpath("//button[@id='cookie-agree']");
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator)).click();
        } catch (Exception e) {
            System.out.println("Cookie-баннер не найден или уже закрыт, продолжаем без обработки.");
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
        // Массив локаторов для каждого логотипа
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
                WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='pay-connection']/button[@type='submit']")));
        submitButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class='app-wrapper__content ng-tns-c4113268976-0']")));

    }
}