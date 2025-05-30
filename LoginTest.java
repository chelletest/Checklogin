package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        WebElement username	= driver.findElement(By.xpath("//input[@name = 'username']"));
        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

        // Validate login success
        if (driver.getCurrentUrl().contains("dashboard")) {
            System.out.println("Login Test Passed.");
        } else {
            System.out.println("Login Test Failed.");
        }

        driver.quit();
    }
}
