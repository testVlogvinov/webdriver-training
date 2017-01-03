import Model.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HW10 {
    private WebDriver driver;
    private String baseUrl = "http://litecart/public_html";
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

        // create object on home page
        Product productOnHomePage = new Product()
                .withName(driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='name']")).getText())
                .withOriginalPrice(driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s[@class='regular-price']")).getText())
                .withSalePrice(driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']//strong[@class='campaign-price']")).getText());

        assertTrue(driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s[@class='regular-price']")).getAttribute("class").equals("regular-price"));
        assertTrue(driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']//strong[@class='campaign-price']")).getAttribute("class").equals("campaign-price"));

        // navigation to PDP
        driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        // create object on PDP
        Product productOnPDP = new Product()
                .withName(driver.findElement(By.xpath("//h1[@class='title']")).getText())
                .withOriginalPrice(driver.findElement(By.xpath("//div[@id='box-product']//div[@class='price-wrapper']/s[@class='regular-price']")).getText())
                .withSalePrice(driver.findElement(By.xpath("//div[@id='box-product']//div[@class='price-wrapper']/strong[@class='campaign-price']")).getText());

        // compare two objects
        assertEquals(productOnHomePage, productOnPDP);

        assertTrue(driver.findElement(By.xpath("//div[@id='box-product']//div[@class='price-wrapper']/s[@class='regular-price']")).getAttribute("class").equals("regular-price"));
        assertTrue(driver.findElement(By.xpath("//div[@id='box-product']//div[@class='price-wrapper']/strong[@class='campaign-price']")).getAttribute("class").equals("campaign-price"));

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
