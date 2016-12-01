import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstWebdriverTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "http://uk.tommy.com";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void testSearch() {
        WebElement search = driver.findElement(By.name("q"));
        WebElement searchIcon = driver.findElement(By.xpath("//button[@name='simplesearch']"));
        search.sendKeys("jeans");
        searchIcon.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}