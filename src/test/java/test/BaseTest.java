package test;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    public static String browserName="chrome";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    @BeforeScenario
    public void setUp() {  //Driver Ayarları Yapılıyor.

        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver.exe"); // Chrome Web Tarayıcısı Olarak Ayarlandı.
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // Tarayıcı Tam Ekran Başlatıldı
        chromeOptions.addArguments("disable-notifications"); // Bildirimler Kapatıltıldı
        chromeOptions.addArguments("disable-popup-blocking"); // Pop-Up'lar Kapatıldı
        setWebDriver(new ChromeDriver(chromeOptions));
        getWebDriver().navigate().to("https://www.trendyol.com"); // Test Sitesine Yönlendirildi.
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //TimeOut Ayarlandı

    }

    public static WebDriver getWebDriver() { //

        return driver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.driver = webDriver;
    }
    @AfterScenario
    public void tearDown(){
        getWebDriver().quit(); //Chrome kapatıldı
    }
}
