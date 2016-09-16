import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Groups {

    WebDriver driver = new WebDriverInit().getWebDriver();
    String url = "http://localhost:8001/";
    private String registrationUsernameXpath = "html/body/div[2]/div/div/form/div[2]/div[1]/input";
    private String registrationEmailXpath = "html/body/div[2]/div/div/form/div[2]/div[2]/input";
    private String registrationPasswordXpath = "html/body/div[2]/div/div/form/div[2]/div[3]/input";
    private String registrationPasswordConfirmXpath = "html/body/div[2]/div/div/form/div[2]/div[4]/input";
    private String regBtnCSS = ".btn.btn-navbar";
    private String signupBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private String loginUsernameXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[1]/input";
    private String loginPasswordXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[2]/input";
    private String GroupsXpath = "html/body/div[1]/div[2]/div/div/div/div/div[2]/a[3]";
    private String GroupsBackBtnXpath = "html/body/div[1]/div[3]/div/a[1]";
    private String GroupsGroupBackBtnXpath = "html/body/div[1]/div[3]/div/a[1]";
    private String GroupsRightBtnXpath = "html/body/div[1]/div[3]/div/a[2]";
    private String GroupsAddGroupBtnXpath = "html/body/div[1]/div[3]/div/a[4]";
    private String GroupsAddPageBtnXpath = "html/body/div[1]/div[3]/div/a[5]";
    private String GroupsInputCss = ".form-control.ng-pristine.ng-untouched.needsclick.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength";
    private String GroupsAddBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private String GroupsCancelBtnCss = ".btn.btn-default";
    private String GroupsBackCancelBtnXpath = "html/body/div[1]/div[3]/div/a[3]";

    HomeButton homeButton = new HomeButton();
    Fairy fairy = Fairy.create();

    @BeforeSuite
    void reg() {
        Person person = fairy.person();
        RegistrationAuthorization reg = new RegistrationAuthorization();
        driver.get(url);
        driver.findElement(By.cssSelector(regBtnCSS)).click();
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
        reg.registrationUsernamePositive(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person);
        driver.findElement(By.xpath(signupBtnXpath)).click();
        reg.loginPos(driver, loginUsernameXpath, loginPasswordXpath, person, 1);
        homeButton.homeButton(driver);
    }

    @BeforeTest
    void home() {
        homeButton.homeButton(driver);
    }

    @Test
    public void groupsBackBtn() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(GroupsXpath)).click();
        driver.findElement(By.xpath(GroupsBackBtnXpath)).click();
        if (driver.getPageSource().contains("Ceo Profile")) {
            System.out.println("Groups Back btn click - success");
        } else {
            System.out.println("Groups Back btn click - fail");
        }
    }

    @Test
    public void groups() {
        //add group
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                driver.findElement(By.xpath(GroupsXpath)).click();
                driver.findElement(By.xpath(GroupsRightBtnXpath)).click();
                driver.findElement(By.xpath(GroupsAddGroupBtnXpath)).click();
                driver.findElement(By.cssSelector(GroupsInputCss)).sendKeys(fairy.textProducer().randomString(15));
                driver.findElement(By.xpath(GroupsAddBtnXpath)).click();
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(GroupsAddPageBtnXpath)));
                if (driver.getPageSource().contains("Remove")) {
                    System.out.println("Groups Group Add - success");
                } else {
                    System.out.println("Groups Group Add - fail");
                }

            } else {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(GroupsAddPageBtnXpath)));
                driver.findElement(By.xpath(GroupsAddPageBtnXpath)).click();
                driver.findElement(By.cssSelector(GroupsInputCss)).sendKeys(fairy.textProducer().randomString(15));
                driver.findElement(By.xpath(GroupsAddBtnXpath)).click();
                if (driver.getPageSource().contains("Remove")) {
                    System.out.println("Groups Group Add - success");
                } else {
                    System.out.println("Groups Group Add - fail");
                }
            }
        }


        //back from group
        driver.findElement(By.xpath(GroupsBackCancelBtnXpath)).click();
        driver.findElement(By.xpath(GroupsRightBtnXpath)).click();
        List<WebElement> groups = driver.findElements(By.cssSelector(".btn.btn-primary.btn-xs.pull-right"));
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).click();
            driver.findElement(By.cssSelector(GroupsCancelBtnCss)).click();
            if (driver.getPageSource().contains("Remove")) {
                System.out.println("Groups Group Back btn click - success");
            } else {
                System.out.println("Groups Group Back btn click - fail");
            }
        }
    }

    @AfterTest
    void afterTest() {
        driver.quit();
    }
}
