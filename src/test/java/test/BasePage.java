package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends BaseTest {

    WebDriverWait driverWait = new WebDriverWait(driver, 60);

    public List<WebElement> listElements(By by) { //Elemenetler Listeleniyor
        return driver.findElements(by);
    }
}
