import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HW7 {
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
        adminUrl = baseUrl + "/admin/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(adminUrl);
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }


    @Test
    public void testAdminLogin() {
        int size = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']")).size();
        for (int i = 1; i <= size; i++) {
            driver.findElement(By.xpath("(//ul[@id='box-apps-menu']/li[@id='app-'])[" + i + "]")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//td[@id='content']/h1")).isDisplayed());
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
