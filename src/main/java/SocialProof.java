import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SocialProof {
    WebDriver driver = new WebDriverInit().getWebDriver();
    String url = "http://localhost:8001/";
    String socialProofXpath = "html/body/div[1]/div[2]/div/div/div/div/div[2]/a[1]";
    String btnSendXpath = "html/body/div[1]/div[3]/div/a[2]";
    String socialProofBackBtnXpath = "html/body/div[1]/div[3]/div/a[1]";
    HomeButton home = new HomeButton();
    private String registrationUsernameXpath = "html/body/div[2]/div/div/form/div[2]/div[1]/input";
    private String registrationEmailXpath = "html/body/div[2]/div/div/form/div[2]/div[2]/input";
    private String registrationPasswordXpath = "html/body/div[2]/div/div/form/div[2]/div[3]/input";
    private String registrationPasswordConfirmXpath = "html/body/div[2]/div/div/form/div[2]/div[4]/input";
    private String regBtnCSS = ".btn.btn-navbar";
    private String signupBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private String loginUsernameXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[1]/input";
    private String loginPasswordXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[2]/input";
    private String closeBtnCss = ".btn.btn-default";
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
    public void socialProof() throws InterruptedException {
        driver.findElement(By.xpath(socialProofXpath)).click();

        List<WebElement> btnPhotos = driver.findElements(By.cssSelector("input[type=\"file\"]"));
        for (WebElement btnPhoto : btnPhotos) {
            btnPhoto.sendKeys("/home/developer/Desktop/Pics/300x300.jpg");
        }

        List<WebElement> counts = driver.findElements(By.cssSelector(".badge.ng-binding"));
        for (WebElement count : counts) {
            if (!count.getText().equals("0")) {
                System.out.println("Social Proof Photo upload " + count.getLocation() + " - success");
            } else {
                System.out.println("Social Proof Photo upload " + count.getLocation() + " - ERROR");
            }
        }

        List<WebElement> socialProofs = driver.findElements(By.cssSelector(".ng-binding"));

//        System.out.println(socialProofs.size());
        for (int i = 0; i < socialProofs.size(); i++) {
            if (socialProofs.get(i).getText().length() > 2) {
                socialProofs.get(i).click();
                if (driver.findElement(By.cssSelector(".img-responsive")).isDisplayed()) {
                    System.out.println("Social Proof element click - success");
                } else {
                    System.out.println("Social Proof element click - FAIL");
                }
                driver.findElement(By.xpath(socialProofBackBtnXpath)).click();
                Thread.sleep(1000);
                socialProofs = driver.findElements(By.cssSelector(".ng-binding"));
            }
        }

        driver.findElement(By.xpath(btnSendXpath)).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(closeBtnCss)).click();
        driver.findElement(By.xpath(socialProofBackBtnXpath)).click();
        if (driver.getPageSource().contains("Ceo Profile")) {
            System.out.println("Social Proof Back Btn click - success");
        } else {
            System.out.println("Social Proof Back Btn click - FAIL");
        }
        driver.findElement(By.xpath(socialProofXpath)).click();
        List<WebElement> elements = driver.findElements(By.cssSelector(".badge.ng-binding"));
        for (WebElement count : elements) {
            if (count.getText().equals("0")) {
                System.out.println("Social Proof Photo send " + count.getLocation() + " - success");
            } else {
                System.out.println("Social Proof Photo send " + count.getLocation() + " - ERROR");
            }
        }

        if (home.homeButton(driver) == 1) {
            System.out.println("Social Proof - Home button ok");
        } else {
            System.out.println("Social Proof - Home button ERROR");
        }
    }

    @AfterTest
    void afterTest() {
        driver.quit();
    }
}
