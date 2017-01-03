import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HW11 {
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
    public void registration(){
        String tempEmail = "asd" + generator.randomValue() + "@gmail.com";
        // registration
        driver.findElement(By.xpath("//form[@name='login_form']//tr//td/a[@href='http://litecart/public_html/en/create_account']/../..")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("02217");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(tempEmail);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+380676787656");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pass");
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys("pass");
        driver.findElement(By.xpath("//button[@name='create_account']")).click();

        // logout
        driver.findElement(By.xpath("//div[@id='box-account']//a[@href='http://litecart/public_html/en/logout']/../a")).click();

        // login
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(tempEmail);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pass");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

}
