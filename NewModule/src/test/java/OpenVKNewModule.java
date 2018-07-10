import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenVKNewModule {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       driver = new ChromeDriver();

    }

    @Test
    public void OpeningVK(){
        driver.get("https://vk.com/");
    }

    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
