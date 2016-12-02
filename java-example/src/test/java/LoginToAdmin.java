import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToAdmin {

    private WebDriver driver;
    private String baseUrl = "http://litecart/public_html";
    private String adminUrl;
    private String username = "admin";
    private String password = "admin";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        adminUrl = baseUrl + "/admin/";
    }


    @Test
    public void testAdminLogin() {
        driver.get(adminUrl);
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
