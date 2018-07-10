import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenGoogleTest {
WebDriver driver;   //обьявили класс

    @BeforeMethod   // запуск создания
    public void setUp(){    //создали метод запуска хрома

        driver = new ChromeDriver();   //инициализация обьекта
    }

    @Test // запуск открытия
    public void siteOpeningTest(){  // метод открытия сайта
        driver.get("https://www.google.com/");
    }

    @AfterClass // запуск закрытия
    public void tearDown(){     // метод закрытия сайта
       // driver.quit(); //чтобы окно не закрывалось после открытия
    }


}
