import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class Computer
    {
    static WebDriver driver;

     public  static void Sleep1(int time)
     {
         try {
             Thread.sleep(time*1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     public static  void WaitUntilElementClickable(By by,int exwait){
         WebDriverWait wait =new WebDriverWait(driver,exwait);
         wait.until(ExpectedConditions.elementToBeClickable(by)).click();
     }
     public static String GetText(By by)
     {
         return driver.findElement(by).getText();
     }
     public static  void clickable(By by)
     {
         driver.findElement(by).click();
     }
    public static void ChromeHomeOpen()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
     public static void closeProgramme()
     {
         driver.close();
     }
     @Test
    public static void RegistrationVerify(){
        ChromeHomeOpen();
        clickable(By.xpath("//a[text()=\"Computers \"] "));
        Sleep1(5);
       // WaitUntilElementClickable(By.xpath("//a[text()=\"Desktops \" ]"),30);
        clickable(By.xpath("//a[text()=\" Desktops \"] "));
       Sleep1(3);
       // WaitUntilElementClickable(By.xpath("//ul[@class=\"sublist\"]/li[1]/a"),10);
        String expectedText="Build your own computer";
       Sleep1(2);
        String actualText =GetText(By.xpath("//a[text()= \"Build your own computer\"]"));
        Sleep1(3);
        Assert.assertEquals(actualText,expectedText);
         String pageText=driver.findElement(By.xpath("//a[text()= \"Build your own computer\"]")).getText();
        System.out.println(actualText);
        closeProgramme();
    }
}
