import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class RegistrationAuthorization {

    Fairy fairy = Fairy.create();

    public void login(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {

        if (i == 0) {
            loginPos(driver, loginUsernameXpath, loginPasswordXpath, person, i);
        } else if (i == 1) {
            emptyPass(driver, loginUsernameXpath, person, i);
        } else if (i == 2) {
            emptyUsername(driver, loginPasswordXpath, person);
        }
    }

    public void registration(WebDriver driver, String registrationUsernameXpath, String registrationEmailXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Integer usernameLimit, Integer passwordLimit, Integer passwordMinSize, Integer emailLimit, Integer emailMinSize, Person person, Integer i) {
        if (i == 0) {
            registrationUsernamePositive(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person);
        } else if (i == 1) {
            registrationUsernameMaxLength(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, usernameLimit);
        } else if (i == 2) {
            registrationUsernameMaxLengthPlusOne(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, usernameLimit);
        } else if (i == 3) {
            registrationUsernameMaxLengthPlusSpace(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, usernameLimit);
        } else if (i == 4) {
            registrationUsernameMaxLengthPlusDeprecatedSymbol(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, usernameLimit);
        } else if (i == 5) {
            registrationUsernameScript(driver, registrationUsernameXpath, registrationPasswordXpath, person, registrationPasswordConfirmXpath);
        } else if (i == 6) {
            registrationPasswordMaxLength(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordLimit);
        } else if (i == 7) {
            registrationPasswordMaxLengthPlusOne(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordLimit);
        } else if (i == 8) {
            registrationPasswordMaxLengthPlusSpace(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordLimit);
        } else if (i == 9) {
            registrationPasswordMaxLengthPlusTab(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordLimit);
        } else if (i == 10) {
            registrationPasswordMinLength(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordMinSize);
        } else if (i == 11) {
            registrationPasswordMinLengthMinusOne(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordMinSize);
        } else if (i == 12) {
            registrationPasswordMinLengthMinusOnePlusSpace(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordMinSize);
        } else if (i == 13) {
            registrationPasswordMinLengthMinusOnePlusTab(driver, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, passwordMinSize);
        } else if (i == 14) {
            registrationEmailPositive(driver, registrationEmailXpath, registrationPasswordXpath, person, registrationPasswordConfirmXpath);
        } else if (i == 15) {
            registrationEmailMaxLength(driver, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, emailLimit);
        } else if (i == 16) {
            registrationEmailMaxLengthPlusOne(driver, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, emailLimit);
        } else if (i == 17) {
            registrationEmailMaxLengthPlusSpace(driver, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, emailLimit);
        } else if (i == 18) {
            registrationEmailMaxLengthPlusDeprecatedSymbol(driver, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, emailLimit);
        } else if (i == 19) {
            registrationEmailScript(driver, registrationUsernameXpath, registrationPasswordXpath, person, registrationPasswordConfirmXpath);
        } else if (i == 20) {
            registrationEmailMinLength(driver, registrationEmailXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, emailMinSize);
            }
    }

    public void loginNegative (WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer i, Integer j) {
        if (i == 0) {
            loginEmptyPass(driver, loginUsernameXpath, person, j);
        } else if (i == 1) {
            loginEmptyUsername(driver, loginPasswordXpath, person);
        } else if (i == 2) {
            loginWrongPass(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 3) {
            loginWrongUsername(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 4) {
            loginWrongUsernamePass(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 5) {
            loginReverse(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 6) {
            loginScriptUsername(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 7) {
            loginSQLUsername(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 8) {
            loginScriptUsername2(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 9) {
            loginScriptUsername3(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 10) {
            loginSymbUsername(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 11) {
            loginSymbUsername2(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else  if (i == 12) {
            loginScriptUsername4(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 13) {
            loginSpaceUsername(driver, loginUsernameXpath, loginPasswordXpath, person);
        } else if (i == 14) {
            loginSpaceBeforeUsername(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 15) {
            loginSpaceAfterUsername(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 16) {
            loginBackSpace(driver, loginUsernameXpath, loginPasswordXpath, person, j);
        } else if (i == 17) {
            loginBigSmallLettersUsername(driver, loginUsernameXpath, loginPasswordXpath, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, j);
        } else if (i == 18) {
            loginBigSmallLettersPass(driver, loginUsernameXpath, loginPasswordXpath, registrationUsernameXpath, registrationPasswordXpath, registrationPasswordConfirmXpath, person, j);
        } else if (i == 19) {
            loginTrimSymb(driver, loginUsernameXpath, loginPasswordXpath, person);
        }
    }

    public void registrationUsernamePositive(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person) {
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationUsernameMaxLength(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer usernameLimit){
        String usernameMaxLength = fairy.textProducer().randomString(usernameLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(usernameMaxLength);
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationUsernameMaxLengthPlusOne(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer usernameLimit){
        String usernameMaxLength = fairy.textProducer().randomString(usernameLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(usernameMaxLength + "a");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationUsernameMaxLengthPlusSpace(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer usernameLimit){
        String usernameMaxLength = fairy.textProducer().randomString(usernameLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(usernameMaxLength + " ");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationUsernameMaxLengthPlusDeprecatedSymbol(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer usernameLimit){
        String usernameMaxLength = fairy.textProducer().randomString(usernameLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(usernameMaxLength + ">");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationUsernameScript(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, Person person, String registrationPasswordConfirmXpath) {
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys("<script>alert(123)</script>");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailPositive(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, Person person, String registrationPasswordConfirmXpath) {
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(person.email());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailMaxLength(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer emailLimit){
        String emailMaxLength = fairy.textProducer().randomString(emailLimit);
//        System.out.println(emailMaxLength);
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(emailMaxLength.substring(0, (emailLimit - 3)/2) + "@" + emailMaxLength.substring((emailLimit - 3)/2, emailLimit - 3) + "." + emailMaxLength.substring(emailLimit - 3));
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailMaxLengthPlusOne(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer emailLimit){
        String emailMaxLength = fairy.textProducer().randomString(emailLimit);
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(emailMaxLength.substring(0, (emailLimit - 3)/2) + fairy.textProducer().randomString(1) + "@" + emailMaxLength.substring((emailLimit - 3)/2, emailLimit - 3) + "." + emailMaxLength.substring(emailLimit - 3));
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailMaxLengthPlusSpace(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer emailLimit){
        String emailMaxLength = fairy.textProducer().randomString(emailLimit);
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(emailMaxLength.substring(0, (emailLimit - 3)/2) + "@" + emailMaxLength.substring((emailLimit - 3)/2, emailLimit - 3) + "." + emailMaxLength.substring(emailLimit - 3) + " ");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailMaxLengthPlusDeprecatedSymbol(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer emailLimit){
        String emailMaxLength = fairy.textProducer().randomString(emailLimit);
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(emailMaxLength.substring(0, (emailLimit - 3)/2) + "@" + emailMaxLength.substring((emailLimit - 3)/2, emailLimit - 3) + "." + emailMaxLength.substring(emailLimit - 3) + ">");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailMinLength(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer emailMinSize){
        String emailMinLength = fairy.textProducer().randomString(emailMinSize);
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys(emailMinLength.substring(0, (emailMinSize - 2)/2) + "@" + emailMinLength.substring((emailMinSize - 2)/2, emailMinSize - 1) + "." + emailMinLength.substring(emailMinSize - 1));
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationEmailScript(WebDriver driver, String registrationEmailXpath, String registrationPasswordXpath, Person person, String registrationPasswordConfirmXpath) {
        driver.findElement(By.xpath(registrationEmailXpath)).sendKeys("<script>alert(123)</script>");
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
    }

    public void registrationPasswordMaxLength(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordLimit){
        String passwordMaxLength = fairy.textProducer().randomString(passwordLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMaxLength);
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMaxLength);
    }

    public void registrationPasswordMaxLengthPlusOne(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordLimit){
        String passwordMaxLength = fairy.textProducer().randomString(passwordLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMaxLength + "1");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMaxLength + "1");
    }

    public void registrationPasswordMaxLengthPlusSpace(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordLimit){
        String passwordMaxLength = fairy.textProducer().randomString(passwordLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMaxLength + " ");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMaxLength + " ");
    }

    public void registrationPasswordMaxLengthPlusTab(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordLimit){
        String passwordMaxLength = fairy.textProducer().randomString(passwordLimit);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMaxLength + "  ");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMaxLength + "  ");
    }

    public void registrationPasswordMinLength(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordMinSize){
        String passwordMinLength = fairy.textProducer().randomString(passwordMinSize);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMinLength);
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMinLength);
    }

    public void registrationPasswordMinLengthMinusOne(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordMinSize){
        String passwordMinLength = fairy.textProducer().randomString(passwordMinSize - 1);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMinLength);
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMinLength);
    }

    public void registrationPasswordMinLengthMinusOnePlusSpace(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordMinSize){
        String passwordMinLength = fairy.textProducer().randomString(passwordMinSize - 1);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMinLength + " ");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMinLength + " ");
    }

    public void registrationPasswordMinLengthMinusOnePlusTab(WebDriver driver, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer passwordMinSize){
        String passwordMinLength = fairy.textProducer().randomString(passwordMinSize - 1);
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(passwordMinLength + "  ");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(passwordMinLength + "  ");
    }

    public void loginPos(WebDriver driver,String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username());
        } else {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email());
        }
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(loginPasswordXpath)).submit();
    }

    public void emptyPass(WebDriver driver, String loginUsernameXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username());
            driver.findElement(By.xpath(loginUsernameXpath)).submit();
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email());
            driver.findElement(By.xpath(loginUsernameXpath)).submit();
        }
    }

    public void emptyUsername(WebDriver driver, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(loginPasswordXpath)).submit();
    }

    public void loginEmptyPass(WebDriver driver, String loginUsernameXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username());
            driver.findElement(By.xpath(loginUsernameXpath)).submit();
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email());
            driver.findElement(By.xpath(loginUsernameXpath)).submit();
        }
    }

    public void loginEmptyUsername(WebDriver driver, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(loginPasswordXpath)).submit();
    }

    public void loginWrongPass(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.firstName() + person.lastName());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.firstName() + person.lastName());
        }
    }

    public void loginWrongUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.firstName() + person.lastName());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("a" + person.email());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        }
    }

    public void loginWrongUsernamePass(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.firstName() + person.lastName());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.firstName() + person.lastName());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("a" + person.email());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.firstName() + person.lastName());
        }
    }

    public void loginReverse(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.password());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.username());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.password());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.email());
        }
    }

    public void loginScriptUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("<script>alert(123)</script>");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginSQLUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("‘ or ‘a’ = ‘a’; DROP TABLE user; SELECT * FROM blog WHERE code LIKE ‘a%’;");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginScriptUsername2(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("<script>alert(“Hello, world!”)</alert>, <script>document.getElementByID(“…”).disabled=true</script>");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginScriptUsername3(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("<form action=”http://live.hh.ru”><input type=”submit”></form>");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginScriptUsername4(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("${code}");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginSymbUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("♣☺♂♣☺♂");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginSymbUsername2(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("‘~!@#$%^&*()?>,./<][ /*<!–");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginSpaceUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("       ");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginSpaceBeforeUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("   " + person.username());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("   " + person.email());
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        }
    }

    public void loginSpaceAfterUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username() + "   ");
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email() + "   ");
            driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        }
    }

    public void loginBackSpace(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username());
        } else if (i == 1){
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email());
        }
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.chord(Keys.BACK_SPACE)).perform();
    }

    public void loginBigSmallLettersUsername(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer i) {
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("UsErnAme");
        } else  if (i == 1) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("UsErnAme@example.com");
        }
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys(person.password());
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).submit();
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("username");
        } else  if (i == 1) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("username@example.com");
        }
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public void loginBigSmallLettersPass(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, String registrationUsernameXpath, String registrationPasswordXpath, String registrationPasswordConfirmXpath, Person person, Integer i) {
        driver.findElement(By.xpath(registrationUsernameXpath)).sendKeys(person.username());
        driver.findElement(By.xpath(registrationPasswordXpath)).sendKeys("PassWorD@123");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).sendKeys("PassWorD@123");
        driver.findElement(By.xpath(registrationPasswordConfirmXpath)).submit();
        if (i == 0) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.username());
        } else  if (i == 1) {
            driver.findElement(By.xpath(loginUsernameXpath)).sendKeys(person.email());
        }
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys("password");
    }

    public void loginTrimSymb(WebDriver driver, String loginUsernameXpath, String loginPasswordXpath, Person person) {
        driver.findElement(By.xpath(loginUsernameXpath)).sendKeys("<" + person.username() + ">");
        driver.findElement(By.xpath(loginPasswordXpath)).sendKeys(person.password());
    }

    public String getCurrentReg (Integer i) {
        String current = null;
        if (i == 0) {
            current = "registrationUsernamePositive";
        } else if (i == 1) {
            current = "registrationUsernameMaxLength";
        } else if (i == 2) {
            current = "registrationUsernameMaxLengthPlusOne";
        } else if (i == 3) {
            current = "registrationUsernameMaxLengthPlusSpace";
        } else if (i == 4) {
            current = "registrationUsernameMaxLengthPlusDeprecatedSymbol";
        } else if (i == 5) {
            current = "registrationUsernameScript";
        } else if (i == 6) {
            current = "registrationPasswordMaxLength";
        } else if (i == 7) {
            current = "registrationPasswordMaxLengthPlusOne";
        } else if (i == 8) {
            current = "registrationPasswordMaxLengthPlusSpace";
        } else if (i == 9) {
            current = "registrationPasswordMaxLengthPlusTab";
        } else if (i == 10) {
            current = "registrationPasswordMinLength";
        } else if (i == 11) {
            current = "registrationPasswordMinLengthMinusOne";
        } else if (i == 12) {
            current = "registrationPasswordMinLengthMinusOnePlusSpace";
        } else if (i == 13) {
            current = "registrationPasswordMinLengthMinusOnePlusTab";
        } else if (i == 14) {
            current = "registrationEmailPositive";
        } else if (i == 15) {
            current = "registrationEmailMaxLength";
        } else if (i == 16) {
            current = "registrationEmailMaxLengthPlusOne";
        } else if (i == 17) {
            current = "registrationEmailMaxLengthPlusSpace";
        } else if (i == 18) {
            current = "registrationEmailMaxLengthPlusDeprecatedSymbol";
        } else if (i == 19) {
            current = "registrationEmailScript";
        }
        return current;
    }

    public String getCurrentLoginNeg (Integer i) {
        String current = null;
        if (i == 0) {
            current = "loginEmptyPass";
        } else if (i == 1) {
            current = "loginEmptyUsername";
        } else if (i == 2) {
            current = "loginWrongPass";
        } else if (i == 3) {
            current = "loginWrongUsername";
        } else if (i == 4) {
            current = "loginWrongUsernamePass";
        } else if (i == 5) {
            current = "loginReverse";
        } else if (i == 6) {
            current = "loginScriptUsername";
        } else if (i == 7) {
            current = "loginSQLUsername";
        } else if (i == 8) {
            current = "loginScriptUsername2";
        } else if (i == 9) {
            current = "loginScriptUsername3";
        } else if (i == 10) {
            current = "loginSymbUsername";
        } else if (i == 11) {
            current = "loginSymbUsername2";
        } else  if (i == 12) {
            current = "loginScriptUsername4";
        } else if (i == 13) {
            current = "loginSpaceUsername";
        } else if (i == 14) {
            current = "loginSpaceBeforeUsername";
        } else if (i == 15) {
            current = "loginSpaceAfterUsername";
        } else if (i == 16) {
            current = "loginBackSpace";
        } else if (i == 17) {
            current = "loginBigSmallLettersUsername";
        } else if (i == 18) {
            current = "loginBigSmallLettersPass";
        } else if (i == 19) {
            current = "loginTrimSymb";
        }
        return current;
    }
}
