import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
public class AutoAmTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAutoAm() {
        driver.get("https://auto.am/");

        WebElement searchBox = driver.findElement(By.name("search_text"));
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        WebElement carMake = driver.findElement(By.id("brandSelect"));
        WebElement carModel = driver.findElement(By.id("modelSelect"));
        WebElement carYear = driver.findElement(By.id("yearSelect"));
        WebElement carPrice = driver.findElement(By.id("priceSelect"));

        searchBox.sendKeys("BMW");
        searchButton.click();
        Select makeDropdown = new Select(carMake);
        makeDropdown.selectByVisibleText("BMW");
        Select modelDropdown = new Select(carModel);
        modelDropdown.selectByVisibleText("1-Series");
        Select yearDropdown = new Select(carYear);
        yearDropdown.selectByVisibleText("2015");
        Select priceDropdown = new Select(carPrice);
        priceDropdown.selectByValue("5000");
    }
}
