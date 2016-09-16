import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Registration {
    private WebDriver driver = new WebDriverInit().getWebDriver();
    private String url = "http://localhost:8001";
    private String regBtnCSS = ".btn.btn-navbar";
    private RegistrationAuthorization registrationAuthorization = new RegistrationAuthorization();
    private String registrationUsernameXpath = "html/body/div[2]/div/div/form/div[2]/div[1]/input";
    private String registrationEmailXpath = "html/body/div[2]/div/div/form/div[2]/div[2]/input";
    private String registrationPasswordXpath = "html/body/div[2]/div/div/form/div[2]/div[3]/input";
    private String registrationPasswordConfirmXpath = "html/body/div[2]/div/div/form/div[2]/div[4]/input";
    private String forgotBtnCSS = ".btn-link.forgot-link";
    private String forgotInputCss = ".form-control.ng-pristine.ng-untouched.needsclick.ng-valid-email.ng-invalid.ng-invalid-required";
    private Integer usernameLimit = 25;
    private Integer passwordLimit = 99;
    private Integer passwordMinSize = 6;
    private Integer emailLimit = 25;
    private Integer emailMinSize = 3;
    private String cancelBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[1]";
    private String signupBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private String closeRegBtnXpath = "html/body/div[2]/div/div/form/div[1]/button";
    private Integer i;
    private Fairy fairy = Fairy.create();

    @Test
    public void registration() throws InterruptedException {
//        i = 0;
//        Person person = fairy.person();
//        driver.get(url);
//        driver.findElement(By.cssSelector(regBtnCSS)).click();
//        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
//        registrationAuthorization.registrationPasswordMinLength(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordMinSize);
//        driver.findElement(By.xpath(signupBtnXpath)).click();
//        Thread.sleep(2000);
//        if (driver.getPageSource().contains("has been created!")) {
//            System.out.println("Registration success - current operation " + registrationAuthorization.getCurrentReg(i));
//        } else {
//            System.out.println("Registration fail - current operation " + registrationAuthorization.getCurrentReg(i));
//        }

        for (i = 0; i < 20; i++) {
            if (i <= 13) {
                driver.get(url);
                driver.findElement(By.cssSelector(regBtnCSS)).click();
                Person person = fairy.person();
                driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
                registrationAuthorization.registration(driver, registrationUsernameXpath, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, usernameLimit, passwordLimit, passwordMinSize, emailLimit, emailMinSize, person, i);
//                driver.findElement(By.xpath(registrationEmailXpath)).submit();
                driver.findElement(By.xpath(signupBtnXpath)).click();
                Thread.sleep(1000);
                if (driver.getPageSource().contains("has been created!")) {
                    System.out.println("Registration success - current operation " + registrationAuthorization.getCurrentReg(i));
                } else {
                    System.out.println("Registration fail - current operation " + registrationAuthorization.getCurrentReg(i));
                }
            } else {
                driver.get(url);
                driver.findElement(By.cssSelector(regBtnCSS)).click();
                Person person = fairy.person();
                driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
                registrationAuthorization.registration(driver, registrationUsernameXpath, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, usernameLimit, passwordLimit, passwordMinSize, emailLimit, emailMinSize, person, i);
//                driver.findElement(By.xpath(registrationEmailXpath)).submit();
                driver.findElement(By.xpath(signupBtnXpath)).click();
                Thread.sleep(1000);
                if (driver.getPageSource().contains("has been created!")) {
                    System.out.println("Registration success - current operation " + registrationAuthorization.getCurrentReg(i));
                } else {
                    System.out.println("Registration fail - current operation " + registrationAuthorization.getCurrentReg(i));
                }
            }
        }
    }

    @Test
    public void cancelBtn() {
        driver.get(url);
        driver.findElement(By.cssSelector(regBtnCSS)).click();

        driver.findElement(By.xpath(cancelBtnXpath)).click();
        if (!driver.getPageSource().contains("Cancel")) {
            System.out.println("Registration Cancel button - correct");
        } else {
            System.out.println("Registration Cancel button - ERROR");
        }
    }

    @Test
    public void registrationSignupBtn() {
        Person person = fairy.person();
        driver.get(url);
        driver.findElement(By.cssSelector(regBtnCSS)).click();

        registrationAuthorization.registrationUsernamePositive(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person);
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
        driver.findElement(By.xpath(signupBtnXpath)).click();
        if (driver.getPageSource().contains("Forgot your password?")) {
            System.out.println("Registration Signup button - correct");
        } else {
            System.out.println("Registration Signup button - ERROR");
        }
    }

    @Test
    public void forgotPasswordCancelBtn() {
        driver.get(url);
        driver.findElement(By.cssSelector(forgotBtnCSS)).click();

        driver.findElement(By.xpath(cancelBtnXpath)).click();
        if (!driver.getPageSource().contains("Cancel")) {
            System.out.println("Forgot Password button - correct");
        } else {
            System.out.println("Forgot Password button - ERROR");
        }
    }

    @Test
    public void forgotPassword() {
        driver.get(url);
        driver.findElement(By.cssSelector(forgotBtnCSS)).click();
        Person person = fairy.person();

        driver.findElement(By.cssSelector(forgotInputCss)).sendKeys(person.email());
        driver.findElement(By.cssSelector(forgotInputCss)).submit();
    }

    @Test
    public void forgotPasswordSubmitBtn() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.cssSelector(forgotBtnCSS)).click();
        Person person = fairy.person();

        driver.findElement(By.cssSelector(forgotInputCss)).sendKeys(person.email());
        Thread.sleep(2000);
        driver.findElement(By.xpath(signupBtnXpath)).click();
    }

    @Test
    public void closeRegBtn() {
        driver.get(url);
        driver.findElement(By.cssSelector(regBtnCSS)).click();

        driver.findElement(By.xpath(closeRegBtnXpath)).click();
        if (!driver.getPageSource().contains("Cancel")) {
            System.out.println("Close Registration button - correct");
        } else {
            System.out.println("Close Registration button - ERROR");
        }
    }

    @AfterTest
    void afterTest() {
        driver.quit();
    }
}
