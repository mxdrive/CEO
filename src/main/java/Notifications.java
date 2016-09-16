import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Notifications {
    WebDriver driver = new WebDriverInit().getWebDriver();
    HomeButton btn = new HomeButton();
    String url = "http://localhost:8001/";
    String notificationsXpath = "html/body/div[1]/div[2]/div/div/div/div/div[2]/a[3]";
    String btnDoneXpath = "html/body/div[1]/div[3]/div/a";
    private String registrationUsernameXpath = "html/body/div[2]/div/div/form/div[2]/div[1]/input";
    private String registrationEmailXpath = "html/body/div[2]/div/div/form/div[2]/div[2]/input";
    private String registrationPasswordXpath = "html/body/div[2]/div/div/form/div[2]/div[3]/input";
    private String registrationPasswordConfirmXpath = "html/body/div[2]/div/div/form/div[2]/div[4]/input";
    private String regBtnCSS = ".btn.btn-navbar";
    private String signupBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private String loginUsernameXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[1]/input";
    private String loginPasswordXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[2]/input";
    Fairy fairy = Fairy.create();

    @BeforeTest
    void reg() {
        Person person = fairy.person();
        RegistrationAuthorization reg = new RegistrationAuthorization();
        driver.get(url);
        driver.findElement(By.cssSelector(regBtnCSS)).click();
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
        reg.registrationUsernamePositive(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person);
        driver.findElement(By.xpath(signupBtnXpath)).click();
        reg.loginPos(driver, loginUsernameXpath, loginPasswordXpath, person, 1);
    }

    @Test
    public void notifications() throws InterruptedException {
        driver.findElement(By.xpath(notificationsXpath)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnDoneXpath)).click();
        if (driver.getCurrentUrl().equals(url)) {
            System.out.println("Notifications - Send button ok");
        } else {
            System.out.println("Notifications - Send Button ERROR");
        }

        driver.findElement(By.xpath(notificationsXpath)).click();
        if (btn.homeButton(driver) == 1) {
            System.out.println("Notifications - Home button ok");
        } else {
            System.out.println("Notifications - Home button ERROR");
        }
    }

    @AfterTest
    void afterTest() {
        driver.quit();
    }
}
