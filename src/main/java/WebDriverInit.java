import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public class WebDriverInit{
    public WebDriver driver;

    void init() {
        System.setProperty("webdriver.chrome.driver", "/home/developer/IdeaProjects/Automation/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8001/");

    }

    void initFirefox() {
        System.setProperty("webdriver.gecko.driver", "/home/developer/IdeaProjects/Automation/geckodriver");
        driver = new MarionetteDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo:demo@versionhistory.demo.zerp.info/login");
        driver.switchTo().alert().accept();
    }

    public WebDriver getWebDriver() {
        init();
        return driver;
    }

//    public WebDriver getWebDriver() {
//        for (int i = 0; i < 2; i++) {
//            webDriver = null;
//            if (i == 0) {
//                init();
//            } else if (i == 1) {
//                initFirefox();
//            }
//        }
//        return webDriver;
//    }

    public WebDriver getFFDriver() {
        initFirefox();
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void setupAfterSuite() {
        driver.quit();
    }
}
