import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomeButton {
    String url = "http://localhost:8001/";
    String sideMenuClass = "fa-ellipsis-v";
    String homeClass = "fa-home";

    @Test
    public int homeButton(WebDriver driver) {
        int i = 0;
//        driver.findElement(By.className(sideMenuClass)).click();
        driver.findElement(By.className(homeClass)).click();
        if (driver.getCurrentUrl().equals(url)) {
            i = 1;
        }
        return i;
    }
}
