
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trello {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    driver = new FirefoxDriver(); //можно подключить любой драйвер
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testTrello() {
    // open site
    openSite();
    driver.findElement(By.xpath("//*[@href='/signup']")).click();// заменили слово "зарегистрироваться"

    fillNameFill();

    fillEmailField();

    fillPasswordFill();

    clickOnsinghButton();

    driver.findElement(By.linkText("вход")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys("nanabara@gmail.com");

    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("baranova30");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/div/div/div/div/div/nav/div/ul/li[2]/a/span[2]")).click();

  }

  public void clickOnsinghButton() {
    driver.findElement(By.id("signup")).click();
  }

  public void fillPasswordFill() {
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("baranova30");
  }

  public void fillEmailField() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("nanabara@gmail.com");
  }

  public void fillNameFill() {
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("nadiia");
  }

  public void openSite() {
    driver.get("https://trello.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws InterruptedException {
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
