
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ebay {
    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testEbay() throws Exception {
        driver.get("https://www.ebay.com/");

        driver.findElement(By.linkText("Sign in")).click();

        fillUserID();

        fillPassword();

        clickOnSighBut();
    }

    public void clickOnSighBut() {
        driver.findElement(By.id("sgnBt")).click();
    }

    public void fillPassword() {
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("baranova30");
    }

    public void fillUserID() {
        driver.findElement(By.id("userid")).click();
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys("nanabara@gmail.com");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
        }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
  }
