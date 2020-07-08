import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Digital_Storm {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver,50);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[text()=\"Computers \"] ")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a")).click();
        driver.findElement(By.xpath("//a[text()=\"Digital Storm VANQUISH 3 Custom Performance PC\"]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@value=\"Email a friend\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"send-email\"]")).click();
        String pageText1 = driver.findElement(By.xpath("//span[text()=\"Enter friend's email\"]")).getText();
        System.out.println(pageText1);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("\"Enter your email\"")));
        String expectedText="Enter Email";
        String actualtext= driver.findElement(By.linkText("Enter your email")).getText();
        Assert.assertEquals(actualtext,expectedText,"Result Not Found");
        System.out.println(actualtext);
        driver.close();
    }
}

