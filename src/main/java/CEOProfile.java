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

import java.util.ArrayList;
import java.util.List;

public class CEOProfile {
    WebDriver driver = new WebDriverInit().getWebDriver();
    String url = "http://localhost:8001/";
    String ceoProfileXpath = "html/body/div[1]/div[2]/div/div/div/div/div[2]/a[2]";
    String ceoGoalsXpath = "html/body/div[1]/div[2]/div/div/div/div/div/a[1]";
    String ceoCalendarXpath = "html/body/div[1]/div[2]/div/div/div/div/div/a[2]";
    String ceoNotesXpath = "html/body/div[1]/div[2]/div/div/div/div/div/a[4]";
    String ceoNotesBackBtnXpath = "html/body/div[1]/div[3]/div/a";
    String ceoLessonPlansXpath = "html/body/div[1]/div[2]/div/div/div/div/div/a[3]";
    String ceoLessonPlansBackBtnXpath = "html/body/div[1]/div[3]/div/a[1]";
    String ceoLessonPlansPlanBackBtnXpath = "html/body/div/div[1]/div[3]/div/a";
    String ceoLessonPlansEditGroupsXpath = "html/body/div[1]/div[3]/div/a[2]";
    String ceoLessonPlansGroupAddXpath = "html/body/div[1]/div[3]/div/a[4]";
    String ceoLessonPlansGroupAddInputCss = ".form-control.ng-pristine.ng-untouched.needsclick.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength";
    String ceoLessonPlansEditPlanCss = ".form-control.ng-pristine.ng-untouched.ng-valid.needsclick.ng-valid-required.ng-valid-minlength.ng-valid-parse.ng-valid-maxlength";
    String ceoLessonPlansGroupAddBtnClass = "btn-primary";
    String ceoLessonPlansDocUploadBtnCss = ".btn.btn-sm.btn-info.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required";
    String ceoGoalsNewInput = "html/body/div[2]/div/div/form/div[2]/div/input";
    String ceoScoreboardXpath = "html/body/div[1]/div[2]/div/div/div/div/a";
    String ceoCalendarDateXpath = "html/body/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[3]/td[2]/div";
    String monthBackXpath = "html/body/div[1]/div[2]/div/div/div/div/div[1]/div[1]/button";
    String monthForwardXpath = "html/body/div[1]/div[2]/div/div/div/div/div[1]/div[3]/button";
    String monthNameCss = ".calendar-header.col-xs-8.ng-binding";
    String ceoCalendarBackBtn = "html/body/div[1]/div[3]/div/a";
    String ceoGoalsCheckboxClickedCss = ".ng-valid.needsclick.ng-touched.ng-dirty.ng-valid-parse";
    String ceoGoalsCheckboxUnclickedCss = ".ng-pristine.ng-valid";
    String ceoGoalsBackBtnXpath = "html/body/div[1]/div[3]/div/a";
    String apprenticesXpath = "html/body/div[1]/div[2]/div/div/div/div/div[1]/div[2]/a";
    String dealsXpath = "html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/a";
    String financialXpath = "html/body/div[1]/div[2]/div/div/div/div/div[3]/div[2]/a";
    private String registrationUsernameXpath = "html/body/div[2]/div/div/form/div[2]/div[1]/input";
    private String registrationEmailXpath = "html/body/div[2]/div/div/form/div[2]/div[2]/input";
    private String registrationPasswordXpath = "html/body/div[2]/div/div/form/div[2]/div[3]/input";
    private String registrationPasswordConfirmXpath = "html/body/div[2]/div/div/form/div[2]/div[4]/input";
    private String regBtnCSS = ".btn.btn-navbar";
    private String signupBtnXpath = "html/body/div[2]/div/div/form/div[3]/button[2]";
    private String loginUsernameXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[1]/input";
    private String loginPasswordXpath = "html/body/div[1]/div[2]/div/div/div/div[2]/form/div/div/div[2]/input";

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
    public void ceoHomeBtn() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        if (homeButton.homeButton(driver) == 1) {
            System.out.println("CEO Profile - Home button ok");
        } else {
            System.out.println("CEO Profile - Home button ERROR");
        }
    }

    @Test
    public void ceoCalendar() throws InterruptedException {

        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoCalendarXpath)).click();
//        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable())
        Thread.sleep(1000);
        if (homeButton.homeButton(driver) == 1) {
            System.out.println("CEO Profile Calendar - Home button ok");
        } else {
            System.out.println("CEO Profile Calendar - Home button ERROR");
        }

        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoCalendarXpath)).click();
        driver.findElement(By.xpath(ceoCalendarDateXpath)).click();
        if (driver.findElement(By.className("monthview-selected")).getCssValue("background-color").equals("rgba(0, 153, 0, 1)")) {
            System.out.println("CEO Calendar - Date is clickable");
        } else {
            System.out.println("CEO Calendar - Date click ERROR");
        }

        String month = driver.findElement(By.cssSelector(monthNameCss)).getText();
        driver.findElement(By.xpath(monthBackXpath)).click();
        if (!driver.findElement(By.cssSelector(monthNameCss)).equals(month)) {
            System.out.println("CEO Calendar - Month change back ok");
        } else {
            System.out.println("CEO Calendar - Month change back ERROR");
        }

        driver.findElement(By.xpath(monthForwardXpath)).click();
        if (!driver.findElement(By.cssSelector(monthNameCss)).equals(month)) {
            System.out.println("CEO Calendar - Month change forward ok");
        } else {
            System.out.println("CEO Calendar - Month change forward ERROR");
        }
    }

    @Test
    public void ceoCalendarBackBtn() {

        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoCalendarXpath)).click();
        driver.findElement(By.xpath(ceoCalendarBackBtn)).click();
        if (driver.getCurrentUrl().contains("ceo-profile")) {
            System.out.println("CEO Calendar - Back button ok");
        } else {
            System.out.println("CEO Calendar - Back button ERROR");
        }
    }

    @Test
    public void ceoNotes() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoNotesXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoNotesBackBtnXpath)));
        driver.findElement(By.xpath(ceoNotesBackBtnXpath)).click();
        if (driver.getCurrentUrl().contains("ceo-profile")) {
            System.out.println("CEO Notes - Back button ok");
        } else {
            System.out.println("CEO Notes - Back button ERROR");
        }
    }

    @Test
    public void ceoNotesHome() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoNotesXpath)).click();
        if (homeButton.homeButton(driver) == 1) {
            System.out.println("CEO Notes - Home button ok");
        } else {
            System.out.println("CEO Notes - Home button ERROR");
        }
    }

    @Test
    public void ceoGoalsHome() throws InterruptedException {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoGoalsXpath)).click();
        Thread.sleep(1000);
        if (homeButton.homeButton(driver) == 1) {
            System.out.println("CEO Goals - Home button ok");
        } else {
            System.out.println("CEO Goals - Home button ERROR");
        }
    }

    @Test
    public void ceoGoals() throws InterruptedException {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoGoalsXpath)).click();

        List<WebElement> goals = driver.findElements(By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.needsclick.ng-valid-min.ng-valid-max.ng-valid-fraction"));

        for (WebElement goal : goals) {
            Integer input = fairy.baseProducer().randomBetween(10, 500);
            goal.sendKeys(Integer.toString(input));
        }
        driver.findElement(By.cssSelector(".btn.btn-info")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoLessonPlansBackBtnXpath)));
        driver.findElement(By.xpath(ceoLessonPlansBackBtnXpath)).click();
        driver.findElement(By.xpath(ceoGoalsXpath)).click();

        if (driver.findElements(By.className("ng-dirty")).size() == 0) {
            System.out.println("CEO Goals Add - success");
        } else {
            System.out.println("CEO Goals Add - FAIL");
        }
//        if (driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/p")).isDisplayed()) {
//            System.out.println("CEO Goals Add - success");
//        } else {
//            System.out.println("CEO Goals Add - fail");
//        }

//        driver.findElement(By.xpath(ceoLessonPlansEditGroupsXpath)).click();
//        String string = fairy.textProducer().randomString(15);
////        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoGoalsNewInput)));
//        driver.findElement(By.xpath(ceoGoalsNewInput)).sendKeys(string);
//        driver.findElement(By.xpath(signupBtnXpath)).click();
//        List<WebElement> checkboxes = driver.findElements(By.xpath("html/body/div[1]/div[2]/div/div/div/div/ul/li[1]/div/label"));
//        for (WebElement checkbox : checkboxes) {
//            if (checkbox.getText().contains(string)) {
//                System.out.println("CEO Goals Add Goal - success");
//                checkbox.click();
//                if (driver.findElement(By.className("line-through")).isDisplayed()) {
//                    System.out.println("CEO Goals Checkbox click - success");
//                } else {
//                    System.out.println("CEO Goals Checkbox click - fail");
//                }
//            } else {
//                System.out.println("CEO Goals Add Goal - fail");
//            }
//        }

//        driver.findElement(By.xpath(ceoLessonPlansBackBtnXpath)).click();
//        if (driver.getPageSource().contains("Calendar")) {
//            System.out.println("CEO Goals Back Btn click - success");
//        } else {
//            System.out.println("CEO Goals Back Btn click - fail");
//        }
//        driver.findElement(By.xpath(ceoGoalsCheckbox1)).click();
//        if (driver.findElement(By.xpath(ceoGoalsCheckbox1)).isSelected()) {
//            System.out.println("CEO Goals - Checkbox 'not selected' ok");
//        } else {
//            System.out.println("CEO Goals - Checkbox 'not selected' ERROR");
//        }
//
//        driver.findElement(By.xpath(ceoGoalsCheckbox2)).click();
//        if (!driver.findElement(By.xpath(ceoGoalsCheckbox2)).isSelected()) {
//            System.out.println("CEO Goals - Checkbox 'selected' ok");
//        } else {
//            System.out.println("CEO Goals - Checkbox 'selected' ERROR");
//        }
//
//        driver.findElement(By.xpath(ceoGoalsCheckbox3)).click();
//        if (driver.findElement(By.xpath(ceoGoalsCheckbox3)).isSelected()) {
//            System.out.println("CEO Goals - Checkbox 'indeterminate' ok");
//        } else {
//            System.out.println("CEO Goals - Checkbox 'indeterminate' ERROR");
//        }
//
//        if (!driver.findElement(By.xpath(ceoGoalsCheckbox4)).isEnabled()) {
//            System.out.println("CEO Goals - Checkbox 'disabled' ok");
//        } else {
//            System.out.println("CEO Goals - Checkbox 'disabled' ERROR");
//        }
//
//        if (!driver.findElement(By.xpath(ceoGoalsCheckbox5)).isEnabled()) {
//            System.out.println("CEO Goals - Checkbox 'disabled selected ' ok");
//        } else {
//            System.out.println("CEO Goals - Checkbox 'disabled selected ' ERROR");
//        }
//
//        if (!driver.findElement(By.xpath(ceoGoalsCheckbox6)).isEnabled()) {
//            System.out.println("CEO Goals - Checkbox 'disabled indeterminate ' ok");
//        } else {
//            System.out.println("CEO Goals - Checkbox 'disabled indeterminate ' ERROR");
//        }
    }

    @Test
    public void ceoGoalsBackBtn() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoGoalsXpath)).click();

        driver.findElement(By.xpath(ceoGoalsBackBtnXpath)).click();
        if (driver.getCurrentUrl().contains("ceo-profile")) {
            System.out.println("CEO Goals - Back button ok");
        } else {
            System.out.println("CEO Goals - Back button ERROR");
        }
    }

    @Test
    public void ceoLessonPlansHome() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoLessonPlansXpath)).click();
        if (homeButton.homeButton(driver) == 1) {
            System.out.println("CEO Lesson Plans - Home button ok");
        } else {
            System.out.println("CEO Lesson Plans - Home button ERROR");
        }
    }

    @Test
    public void ceoLessonPlansBackBtn() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoLessonPlansXpath)).click();
        driver.findElement(By.xpath(ceoLessonPlansBackBtnXpath)).click();
        if (driver.getCurrentUrl().contains("ceo-profile")) {
            System.out.println("CEO Lesson Plans - Back button ok");
        } else {
            System.out.println("CEO Lesson Plans - Back button ERROR");
        }
    }

//    @Test
//    public void ceoLessonPlansPlans() {
//        homeButton.homeButton(driver);
//        driver.findElement(By.xpath(ceoProfileXpath)).click();
//        driver.findElement(By.xpath(ceoLessonPlansXpath)).click();
//        List<WebElement> plans = driver.findElements(By.cssSelector(".list-group-item.ng-binding.ng-scope"));
//        if (plans.size() == 0) {
//            driver.findElement(By.xpath("html/body/div[1]/div[3]/div/a[2]")).click();
//            driver.findElement(By.xpath(ceoLessonPlansGroupAddXpath)).click();
//            String randomString = fairy.textProducer().randomString(15);
//            driver.findElement(By.cssSelector(ceoLessonPlansGroupAddInputCss)).sendKeys(randomString);
//            driver.findElement(By.cssSelector(ceoLessonPlansGroupAddBtnClass)).click();
//            if (!driver.getPageSource().contains("Add New Group")) {
//                System.out.println("CEO Lesson Plans (Plans) Group Add - success");
//            } else {
//                System.out.println("CEO Lesson Plans (Plans) Group Add - fail");
//            }
//        } else  {
//            for (int i = 0; i < plans.size(); i++) {
//                if (i == 0) {
//                    plans.get(i).click();
//                } else {
//                    List<WebElement> plans1 = driver.findElements(By.cssSelector(".list-group-item.ng-binding.ng-scope"));
//                    System.out.println(i);
//                    plans1.get(i).click();
//                }
//
//                List<WebElement> dates = driver.findElements(By.cssSelector(".btn.btn-default.btn-lg.btn-block"));
//                for (WebElement date : dates) {
//                    date.click();
//                    if (date.getCssValue("background-color").equals("rgba(230, 230, 230, 1)")) {
//                        System.out.println("CEO Lesson Plans - Date button ok");
//                    } else {
//                        System.out.println("CEO Lesson Plans - Date button ERROR");
//                    }
//                }
//                if (driver.getCurrentUrl().contains("/lesson-plans/")) {
//                    System.out.println("CEO Lesson Plans - Plan button ok");
//                    driver.findElement(By.xpath(ceoLessonPlansPlanBackBtnXpath)).click();
//                    if (driver.getCurrentUrl().equals("http://localhost:8001/lesson-plans")) {
//                        System.out.println("CEO Lesson Plans - Plan Back button ok ");
//                    } else {
//                        System.out.println("CEO Lesson Plans - Plan Back button ERROR");
//                    }
//                } else {
//                    System.out.println("CEO Lesson Plans - Plan Button ERROR");
//                }
//            }
//        }
//    }

    @Test
    public void ceoPlansAddRemove() {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoLessonPlansXpath)).click();
        driver.findElement(By.xpath(ceoLessonPlansEditGroupsXpath)).click();
        String string = fairy.textProducer().randomString(15);

        //TODO xpath?
//        driver.findElement(By.xpath(ceoLessonPlansGroupAddXpath)).click();
        driver.findElement(By.cssSelector(ceoLessonPlansGroupAddInputCss)).sendKeys(string);
//        driver.findElement(By.cssSelector("input[name=\"file\"]")).sendKeys("/home/developer/txt.txt");
        driver.findElement(By.className(ceoLessonPlansGroupAddBtnClass)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoLessonPlansEditGroupsXpath)));
        if (driver.getPageSource().contains(string)) {
            System.out.println("CEO Profile Plans Add - success");
        } else {
            System.out.println("CEO Profile Plans Add - fail");
        }

        //edit group
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa.fa-edit")));
        driver.findElement(By.cssSelector(".fa.fa-edit")).click();
        driver.findElement(By.cssSelector(ceoLessonPlansEditPlanCss)).sendKeys(string);
        driver.findElement(By.xpath("html/body/div[2]/div/div/form/div[3]/button[2]")).click();
        if (driver.getPageSource().contains(string + string)) {
            System.out.println("CEO Profile Plans Edit - success");
        } else {
            System.out.println("CEO Profile Plans Edit - fail");
        }

        //remove plan
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-danger")));
        driver.findElement(By.cssSelector(".btn.btn-danger")).click();
        if (!driver.getPageSource().contains("Lesson Plans not found!")) {
            System.out.println("CEO Profile Plans Remove - success");
        } else {
            System.out.println("CEO Profile Plans Remove - fail");
        }

//        //checkboxes
//        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.needsclick.ng-valid-min.ng-valid-max.ng-valid-fraction"));
//        if (checkboxes.size() == 0) {
////            driver.findElement(By.xpath(ceoLessonPlansGroupAddXpath)).click();
//            String randomString = fairy.textProducer().randomString(15);
//            driver.findElement(By.cssSelector(ceoLessonPlansGroupAddInputCss)).sendKeys(randomString);
//            driver.findElement(By.cssSelector(ceoLessonPlansGroupAddBtnClass)).click();
//            if (!driver.getPageSource().contains("Add New Group")) {
//                System.out.println("CEO Lesson Plans Group Add - success");
//            } else {
//                System.out.println("CEO Lesson Plans Group Add - fail");
//            }
//        } else {
//            for (int i = 0; i <= checkboxes.size() +1; i++) {
//
//                checkboxes = driver.findElements(By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.needsclick.ng-valid-min.ng-valid-max.ng-valid-fraction"));
//                System.out.println("I - " + i);
//                System.out.println("Checkboxes size - " + checkboxes.size());
//                checkboxes.get(0).click();
//
//                List<WebElement> items = driver.findElements(By.cssSelector(".list-group-item.ng-binding.ng-scope"));
//                int itemListSize = items.size();
//                System.out.println(itemListSize);
//                if (checkboxes.get(0).isSelected()) {
//                    System.out.println("CEO Lesson Plans - Edit Group checkbox selected");
//                    //remove item
//                    driver.findElement(By.xpath("html/body/div/div[1]/div[3]/div/a[4]")).click();
//                    List<WebElement> items1 = driver.findElements(By.cssSelector(".list-group-item.ng-binding.ng-scope"));
//                    int newListItemSize = items1.size();
//                    System.out.println(newListItemSize);
//                    if (newListItemSize != itemListSize) {
//                        System.out.println("CEO Lesson Plans - Edit Group Remove Item ok");
//                        driver.findElement(By.xpath(ceoLessonPlansEditGroupsXpath)).click();
//                    } else {
//                        System.out.println("CEO Lesson Plans - Edit Group Remove Item ERROR");
//                    }
//                } else {
//                    System.out.println("CEO Lesson Plans - Edit Group checkbox ERROR");
//                }
//            }
//        }
    }

    @Test
    public void ceoScoreboardBackBtn () {
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoScoreboardXpath)).click();
        driver.findElement(By.xpath(ceoLessonPlansBackBtnXpath)).click();
        if (driver.getCurrentUrl().contains("ceo-profile")) {
            System.out.println("CEO Lesson Plans - Back button ok");
        } else {
            System.out.println("CEO Lesson Plans - Back button ERROR");
        }
    }

    @Test
    public void ceoScoreboardApprentice() throws InterruptedException {
        Thread.sleep(2000);
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoScoreboardXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(apprenticesXpath)));
        driver.findElement(By.xpath(apprenticesXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoNotesBackBtnXpath)));
        driver.findElement(By.xpath(ceoNotesBackBtnXpath)).click();
        if (driver.getPageSource().contains("Back to CEO Profile")) {
            System.out.println("CEO Scoreboard Apprentice Back btn - success");
        } else {
            System.out.println("CEO Scoreboard Apprentice Back btn - fail");
        }
    }

    @Test
    public void ceoScoreboardDeals() throws InterruptedException {
        Thread.sleep(2000);
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoScoreboardXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(apprenticesXpath)));
        driver.findElement(By.xpath(dealsXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoNotesBackBtnXpath)));
        driver.findElement(By.xpath(ceoNotesBackBtnXpath)).click();
        if (driver.getPageSource().contains("Back to CEO Profile")) {
            System.out.println("CEO Scoreboard Deals Back btn - success");
        } else {
            System.out.println("CEO Scoreboard Deals Back btn - fail");
        }
    }

    @Test
    public void ceoScoreboardFinancial() throws InterruptedException {
        Thread.sleep(2000);
        homeButton.homeButton(driver);
        driver.findElement(By.xpath(ceoProfileXpath)).click();
        driver.findElement(By.xpath(ceoScoreboardXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(apprenticesXpath)));
        driver.findElement(By.xpath(financialXpath)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(ceoNotesBackBtnXpath)));
        driver.findElement(By.xpath(ceoNotesBackBtnXpath)).click();
        if (driver.getPageSource().contains("Back to CEO Profile")) {
            System.out.println("CEO Scoreboard Financial Back btn - success");
        } else {
            System.out.println("CEO Scoreboard Financial Back btn - fail");
        }
    }

    @AfterTest
    void afterTest() {
        driver.quit();
    }
}
