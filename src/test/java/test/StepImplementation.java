package test;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static constants.Constants.*;

public class StepImplementation extends BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);


    @Step("Main Page Control")
    public void assertMainpage(){
        logger.info("Ana sayfa kontrol ediliyor");
        Assert.assertEquals(FIRST_LINK, driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"gender-popup-modal\"]/div/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        logger.info("Ana sayfa Açıldı.");
    }

    @Step("ZoomOut")
    public void zoomOut(){
        logger.info("Sayfa Küçültülüyor");
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='50%';");
        logger.info("Sayfa Küçültüldü.");
    }
    @Step("Arama Butonuna basılıyor")
    public void searchButton(){
        logger.info("Arama Kutusuna Basılıyor");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH))).click();
        logger.info("Arama kutusuna basıldı.");
    }
    @Step("Kablosuz Kulaklık Araması")
    public void wirelessHeadphone(){
        logger.info("Kablosuz Kulaklık Araması Yapılıyor.");
        WebElement element = driver.findElement(By.xpath(SEARCHTEXT));
        element.clear();
        element.sendKeys("Kablosuz Kulaklık");
        element.sendKeys(Keys.ENTER);
        logger.info("Kablosuz kulaklık araması yapıldı.");
    }

    @Step("Arama Sonuçları Kontrol Ediliyor")
    public void resultCheck(){

    }
    @Step("Arama Sonuçları Kontrol ediliyor")
    public void checkXPathArrayValues() {
        List<WebElement> productsName = driver.findElements(By.xpath(ITEMS));
        logger.info("Arama Sonuçları Karşılaştırılıyor.");
        for (WebElement text : productsName) {
            String productText = text.getText();
            if (!productText.isEmpty()) {
                Assert.assertTrue("Her Element bu Kablosuz Kulaklık değerini içeriyor",productText.contains("Kulaklık"));
                System.out.println("Elements text Value: " + productText);
            } else {
                Assert.assertFalse("Her Element bu Kablosuz Kulaklık değerini içeriyor", productText.contains("Kablosuz Kulaklık"));
                System.out.println("Elements text is empty.");
            }

        }
        logger.info("Arama Sonuçları Karşılaştırıldı.");
    }

    @Step("Rastgele Ürün Seçimi")
    public void testRandomProduct() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath(ITEMS));
        Random random = new Random();
        if (elements.isEmpty()) {
            logger.info("Ürünler Bulunamadı.");
            return;
        }


        int randomIndex = random.nextInt(elements.size());
        WebElement randomElement = elements.get(randomIndex);
        logger.info("Rastgele ürün seçiliyor.");
        String storedValue = randomElement.getText();
        Thread.sleep(2000);
        System.out.println("Chosen Product: " + storedValue);
        randomElement.click();
        String ilktablink =driver.getCurrentUrl();
        System.out.println(ilktablink);


        WebDriverWait wait = new WebDriverWait(driver, 20);
        driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);// Yeni sekmeye geç
                String yenilink = driver.getCurrentUrl();
                System.out.println(yenilink + "Yeni sekmeye geçildi!");
                break;
            }

        }
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHIPMENTDETAILS))).click();


       String productName = driver.findElement(By.xpath(PRODUCTTEXT)).getText();

            if (productName.contains(storedValue)){
                  logger.info(("Product is OK " + productName));
             }else{
                  logger.info("Product is not OK " + productName);
               }
            driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(PDADDTOCART))).click();

            logger.info("Rastgele Ürün Seçildi.");
        }



        @Step("Sepete Ürün Seçimi")
    public void addToCart() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath(SLTADDTOCART));
        Random random = new Random();
        if (elements.isEmpty()) {
            logger.info("Ürünler Bulunamadı.");
            return;
        }
            logger.info("Ürünler Bulundu.");

        int randomIndex = random.nextInt(elements.size());
        WebElement randomElement = elements.get(randomIndex);
        String storedValue = randomElement.getText();
            System.out.println("Chosen Product: " + storedValue);
        randomElement.click();
            logger.info("Ürün sepete Eklendi.");

    }
    @Step("Sepet Açılıyor")
    public void cartOpen(){
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(CART))).click();
        logger.info("Sepet Acildi.");

    }

    @Step("Sepete Rastgele Ürün Ekleniyor")
    public void randomItem() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath(ITEMS));
        Random random = new Random();
        if (elements.isEmpty()) {
            logger.info("Ürünler Bulunamadı.");
            return;
        }


        int randomIndex = random.nextInt(elements.size());
        WebElement randomElement = elements.get(randomIndex);
        logger.info("Rastgele ürün seçiliyor.");
        String storedValue = randomElement.getText();
        Thread.sleep(2000);
        System.out.println("Chosen Product: " + storedValue);
        randomElement.click();
        String ilktablink =driver.getCurrentUrl();
        System.out.println(ilktablink);


        WebDriverWait wait = new WebDriverWait(driver, 20);
        driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);// Yeni sekmeye geç
                String yenilink = driver.getCurrentUrl();
                System.out.println(yenilink + "Yeni sekmeye geçildi!");
                break;
            }

        }
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHIPMENTDETAILS))).click();


        String productName = driver.findElement(By.xpath(PRODUCTTEXT)).getText();

        if (productName.contains(storedValue)){
            logger.info(("Product is OK " + productName));
        }else{
            logger.info("Product is not OK " + productName);
        }
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(PDADDTOCART))).click();

        logger.info("Rastgele Ürün Seçildi.");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(CART))).click();
        logger.info("Sepet Acildi.");

        String orderDetails = driver.findElement(By.xpath(CARTDETAIL)).getText();

        if (orderDetails.contains(productName)){
            logger.info(("Product is OK " + orderDetails));
        }else{
            logger.info("Product is not OK " + orderDetails);
        }
    }

    @Step("Ürün Silme")
    public void productDelete(){
        logger.info("Ürün Siliniyor.");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(TRASHICON))).click();
        logger.info("Ürün Silindi.");

        String summaryBoxText = driver.findElement(By.xpath(SUMMARYBOX)).getText();

        if (summaryBoxText.contains("0")){
            logger.info(("Siparis Silindi" + summaryBoxText));
        }else{
            logger.info("Siparis Silinmedi " + summaryBoxText);
        }

    }





}


