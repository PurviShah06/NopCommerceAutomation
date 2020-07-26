import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration_Automation
{
    static WebDriver driver;
    public  static void Sleep1(int time)//Method for Thread Sleep Wait
    {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static  void waitUntilElementClickable(By by, int waittime)//Method for Explicit Wait
    {
        WebDriverWait wait =new WebDriverWait(driver,waittime);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static  void waituntillElmentVisible(By by,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static String GetText(By by)
    {
        return driver.findElement(by).getText();
    }//Method for GetText from Element
    public static  void clickable(By by)
    {
        driver.findElement(by).click(); }//Method for Clickable Element
    public static long TimeStamp() {//Method for DateTimeStamp

        return (System.currentTimeMillis()); }
    public static void SelectDropDownTextvalue(By by, String text){//Method for DropDown box byTextvalue
        Select select=new Select(driver.findElement(by));
        select.selectByValue(text);
    }
    public static void selectDropDownIndexValue(By by, int indexvalue){//Method for DropDown box byIndexValue
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(indexvalue);
    }
    public static void selectDropDownVisibleText(By by, String textvalue){//Method for DropDown box by Visible Text
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(textvalue);
    }
    public static void sendKeyElements(By by, String Text1){//Method for Send Text Element
        driver.findElement(by).click();
        driver.findElement(by).sendKeys(Text1);
    }
    @BeforeMethod//Annotation
    public static void chromeHomeOpen()//Method for Open HomePage
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");//Open chromedriver Exe
        driver=new ChromeDriver();//Object creat
        driver.manage().window().maximize();//window maximize
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//default implicit wait
        driver.get("https://demo.nopcommerce.com/");
    }
    public static void whenClickablemehtodNotWorking(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


   @AfterMethod
     public static void CloseApplication(){
        driver.close();
 }
    @Test(priority = 0)//Annotation
    public  void userShouldBeAbletoRegisterSuccessfully()
    {
        whenClickablemehtodNotWorking(By.xpath("//div[@class=\"header-links\"]/ul[1]/li[1]/a"));//
        Sleep1(3);
        clickable(By.xpath("//div[@class=\"header-links\"]/ul[1]/li[1]/a"));//click on Register button
        clickable(By.xpath("//input[@id=\"gender-female\"]"));//Select radio buttton
        waituntillElmentVisible(By.cssSelector("input#FirstName"),60);//Add explicite wait
        sendKeyElements(By.xpath("//input[@id=\"FirstName\"]"),"Purvi");//send Text to First name Box
        sendKeyElements(By.xpath("//input[@id=\"LastName\"]"),"Shah");//send Text to last name Box
        SelectDropDownTextvalue(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"6");//Select birthday by Textvalue
        selectDropDownIndexValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),5);//select birthday by indexvalue
        selectDropDownVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1981");//select year by VisibleText
        String date="Textx1+"+TimeStamp()+"@gmail.com";//Date Stamp store in vairable
        sendKeyElements(By.xpath("//input[@id=\"Email\"]"),date);//send email text in emali box
        sendKeyElements(By.xpath("//input[@id=\"Company\"]"),"Xyz ltd.");//send Company name
        sendKeyElements(By.xpath("//input[@id=\"Password\"]"),"polo12");//type password
        sendKeyElements(By.xpath("//input[@id=\"ConfirmPassword\"]"),"polo12");
        whenClickablemehtodNotWorking(By.xpath("//input[@id=\"Newsletter\"]"));//untick newsletter radiobox
        whenClickablemehtodNotWorking(By.xpath("//input[@id=\"register-button\"]"));
        String expectedText="Your registration completed";
        String actualtext=GetText(By.xpath("//div[text()=\"Your registration completed\"]"));
        Assert.assertEquals(actualtext,expectedText);
        System.out.println(actualtext);
        clickable(By.xpath("//input[@class=\"button-1 register-continue-button\"]"));
       // Sleep1(3);
       // registreUserUserShouldbeAbleToReferAProducttoaFriendSucessfully();
    }
    @Test
    public void registreUserUserShouldbeAbleToReferAProducttoaFriendSucessfully(){
        userShouldBeAbletoRegisterSuccessfully();
       waitUntilElementClickable(By.xpath("//a[text()=\"Computers \"]"),10);//Add Explicit Wait
     //   Sleep1(3);
       clickable(By.xpath("//a[text()=\"Computers \"]"));//Click on BeforeTest.Computer Button
       waitUntilElementClickable(By.xpath("//a[text()=\" Desktops \"]"),30);//Explicit WAit
       clickable(By.xpath("//a[text()=\" Desktops \"]"));//Click on Desktop
       waitUntilElementClickable(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[2]/div[1]/div[2]/h2[1]/a"),30);//Add Explicit Wait
       clickable(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[2]/div[1]/div[2]/h2[1]/a"));//click on Add to cart of Digital Storm VANQUISH
       waitUntilElementClickable(By.xpath("//input[@value=\"Email a friend\"]"),30);//add Explicit wait
       clickable(By.xpath("//input[@value=\"Email a friend\"]"));//click on Email a friend button
        sendKeyElements(By.xpath("//input[@id=\"FriendEmail\"]"),"friendmail@gmail.com");//type Friend Mail
        sendKeyElements(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"Please Refer Products and Review it");//add message
        clickable(By.xpath("//input[@name=\"send-email\"]"));//click on send mail button
        String expextedText="Your message has been sent.";//store message to variable
        String actualText=GetText(By.xpath("//div[@class='result']"));//store Text to actual Text variable
        Assert.assertEquals(actualText,expextedText);//Assert to check Expected mathch to actual
        System.out.println(actualText);//printing out
    }
    @Test(priority = 2)
    public static void verificationofElectronicsAddtoCart(){
        waitUntilElementClickable(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"),30);//use Explicit wait
        clickable(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"));//click on Eclectrinics button
        whenClickablemehtodNotWorking(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a"));//Click on Cellphone Button
       //clickable(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a"));//Clickaction on Cell PhoneButton
       waitUntilElementClickable(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"),10);//Explicity wait add
        clickable(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));//Select on "Add to cart"//Click on Add to cart button
        waitUntilElementClickable(By.xpath("//div[@class=\"item-grid\"]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]"),80);//add Explicity wait
        clickable(By.xpath("//div[@class=\"item-grid\"]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]"));Sleep1(6);//click on add to cart button of Nokia Lumia 1020
        whenClickablemehtodNotWorking(By.cssSelector("span.close"));
        clickable(By.cssSelector("span.close"));//click on close Radio box button
        clickable(By.linkText("Shopping cart"));//click on Shopping cart
        String expectedText="HTC One M8 Android L 5.0 Lollipop";//Store data to variable
        waitUntilElementClickable(By.xpath("//tbody/tr[1]/td[4]/a"),40);//Explicit  wait add
        String actualText =GetText(By.xpath("//tbody/tr[1]/td[4]/a"));//Store Text in variable by using locators
        Assert.assertEquals(actualText,expectedText,"");//Check actual with Expected
        String expectedText1="Nokia Lumia 1020";//Expected result git
        waituntillElmentVisible(By.xpath("//tbody/tr[2]/td[4]/a"),20);
        String actualText1 =GetText(By.xpath("//tbody/tr[2]/td[4]/a"));
        Assert.assertEquals(actualText1,expectedText1);

    }
}
