import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Authorization {
    private WebDriver driver = new WebDriverInit().getWebDriver();
    private String url = "http://localhost:8001";
    private RegistrationAuthorization registrationAuthorization = new RegistrationAuthorization();
    private String loginBtnCSS = ".btn.btn-primary.text-capitalize.btn-block";
    private String loginUsernameXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[1]/input";
    private String loginPasswordXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[2]/input";
    private String regBtnCSS = ".btn.btn-navbar";
    private String registrationUsernameXpath = "html/body/div[2]/div/div/form/div[2]/div[1]/input";
    private String registrationEmailXpath = "html/body/div[2]/div/div/form/div[2]/div[2]/input";
    private String registrationPasswordXpath = "html/body/div[2]/div/div/form/div[2]/div[3]/input";
    private String registrationPasswordConfirmXpath = "html/body/div[2]/div/div/form/div[2]/div[4]/input";
    private String signupBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private Integer i;
    String sideMenuXpath = "html/body/div[1]/div[1]/div[2]/div/i";
    String logoutText = "Logout";
    int j = 1;
    Fairy fairy = Fairy.create();
    Person person = fairy.person();

    @BeforeTest
    void reg() {

        driver.get(url);
        if (!driver.getPageSource().contains("Forgot your password?")) {
            logout();
        }
    }

    @Test
    public void authorization() throws InterruptedException {
        driver.findElement(By.cssSelector(regBtnCSS)).click();
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
        registrationAuthorization.registrationUsernamePositive(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person);
        driver.findElement(By.xpath(signupBtnXpath)).click();
        registrationAuthorization.loginPos(driver, loginUsernameXpath, loginPasswordXpath, person, 1);
        for (i = 0; i < 19; i++) {
            if (driver.getPageSource().contains("Social Proof")) {
                logout();
            } else {
                driver.get(url);
                if (i == 17 || i == 18) {
                    driver.findElement(By.cssSelector(regBtnCSS)).click();
                    Person person = fairy.person();
                    driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
                }
            }
            registrationAuthorization.loginNegative(driver, loginUsernameXpath, loginPasswordXpath, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, i, j);
            driver.findElement(By.xpath(loginPasswordXpath)).submit();
            if (driver.getPageSource().contains("Social Proof")) {
                System.out.println("Auth success - current operation " + registrationAuthorization.getCurrentLoginNeg(i));
            } else {
                System.out.println("Auth fail - current operation " + registrationAuthorization.getCurrentLoginNeg(i));
            }

        }
    }

    @Test
    public void auth() throws InterruptedException {
        driver.findElement(By.cssSelector(regBtnCSS)).click();
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
        registrationAuthorization.registrationUsernamePositive(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person);
        driver.findElement(By.xpath(signupBtnXpath)).click();
        registrationAuthorization.loginPos(driver, loginUsernameXpath, loginPasswordXpath, person, 1);
        Thread.sleep(1000);
        if (driver.getPageSource().contains("Social Proof")) {
            System.out.println("Login success");
            logout();
        }
    }

    private void logout() {
//        driver.findElement(By.xpath(sideMenuXpath)).click();
        driver.findElement(By.linkText(logoutText)).click();
    }

    @AfterTest
    void afterTest() {
        driver.quit();
    }
}
