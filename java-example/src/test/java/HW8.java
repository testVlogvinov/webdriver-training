import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW8 {
    private WebDriver driver;
    private String baseUrl = "http://litecart/public_html";
    private String adminUrl;
    private String username = "admin";
    private String password = "admin";
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    @Test
    public void testAdminLogin() {
        List<WebElement> products = driver.findElements(By.cssSelector("div.image-wrapper"));

        for (WebElement product : products) {
            Assert.assertTrue(product.findElement(By.cssSelector("div[class='sticker new'],[class='sticker sale']")).isDisplayed());
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
