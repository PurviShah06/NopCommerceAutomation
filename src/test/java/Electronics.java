import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Electronics
{
    static WebDriver driver;


    public  static String GetTextElement(By by)
    {
       return driver.findElement(by).getText();
    }
    public static void Tread1(int n){
        try {
            Thread.sleep(n *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void WaituntilElementsClickable(){
    }
    public static void main(String[] args)
    {
        //setting up Chromedriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");//
        //crating chromedriver object to open google chrome browser
        driver = new ChromeDriver();
        //maximicing window
        driver.manage().window().maximize();
        //aplaying implicity wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //creat object for explicity wait
        WebDriverWait wait=new WebDriverWait(driver,60);
        //open URL
        driver.get("https://demo.nopcommerce.com/");
        //clicl on link
        driver.findElement(By.xpath("//a[text()=\"Computers \"] ")).click();
      //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.cssSelector("span.close")).click();
        driver.findElement(By.linkText("Shopping cart")).click();
         String pageText1 =driver.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop")).getText();
         System.out.println(pageText1);
         wait.until(ExpectedConditions.elementToBeClickable(By.linkText("HTC One Mini Blue")));
         GetTextElement(By.linkText("HTC One Mini Blue"));
       // String pageText2 =driver.findElement(By.linkText("HTC One Mini Blue")).getText();
       // System.out.println(GetTextElement(By.linkText("HTC One Mini Blue")));
        String pagetext2 =GetTextElement(By.linkText("HTC One Mini Blue"));
        System.out.println(pagetext2);
        driver.close();
    }
}
