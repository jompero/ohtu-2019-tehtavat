package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Random r = new Random();

        driver.get("http://localhost:4567");

        sleep(2);

        // Register
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("jukka" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkuj");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkuj");
        element = driver.findElement(By.name("signup"));
        sleep(2);

        element.submit();
        sleep(3);

        clickLinkWithText("continue to application mainpage", driver);
        sleep(2);

        // Logout
        clickLinkWithText("logout", driver);
        sleep(3); // Now we should be back at front page

        // Login wrong
        clickLinkWithText("login", driver);
        sleep(3);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong");
        element = driver.findElement(By.name("login"));
        sleep(2);

        element.submit();
        sleep(3);

        // Login real
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        sleep(2);

        element.submit();
        sleep(3);

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

    private static void clickLinkWithText(String text, WebDriver driver) {
        int trials = 0;
        while( trials++<2 ) {
            try{
                WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;           
            } catch(Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
