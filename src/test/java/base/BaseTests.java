package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;


public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        //1 - Maximize the window
        //driver.manage().window().maximize();

        //2 - Fullscreen mode
        //driver.manage().window().fullscreen();

        //3 - Specific width (iPhoneX)
        //driver.manage().window().setSize(new Dimension(375, 812));

        homePage = new HomePage(driver);

        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
