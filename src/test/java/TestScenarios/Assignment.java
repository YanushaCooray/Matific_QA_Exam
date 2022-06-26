package TestScenarios;



import Objects.Dashboard;
import Objects.Home;
import Objects.LogIn;
import Objects.ManageClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;


public class Assignment {

    WebDriver driver;

    @BeforeSuite
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test(priority = 0)
    public void  testLoginPageNavigation(){
        Home home=new Home(driver);
        driver.get("https://dev5.matific.com/au/en-au/home/");
        home.clickLogInBtn();
        WebDriverWait wait = new WebDriverWait(driver, 70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username-input']")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev5.matific.com/au/en-au/login-page/" );
    }

    @Test(priority = 1)
    public void testLogin(){
        LogIn logIn=new LogIn(driver);

        logIn.enterUserName("afteacher");
        logIn.clickContinueBtn();
        driver.findElement(By.xpath("//div[contains(text(), 'afteacher')]")).isDisplayed();
        logIn.enterPassword("123");
        logIn.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Class Management']")));

    }

    @Test(priority = 2)
    public void testManageMyClasses(){
        Dashboard dashboard =new Dashboard(driver);
        ManageClass manageClass = new ManageClass(driver);

        dashboard.clickCloseBtn();
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[text()='Class Management']"))).perform();
        manageClass.isDisplayedClassManagementList();
        driver.findElement(By.xpath("//a[@data-test='manage-my-classes']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='page-header-MANAGE_CLASSES']")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev5.matific.com/au/en-au/teachers/class-management/manage-classes" );
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='testclasspost']")));
        actions.perform();
    }

    @Test(priority = 3)
    public void testChangeGradeFunction(){

     ManageClass manageClass=new ManageClass(driver);

        for (int index =2;index<=6;index++){
            manageClass.clickPopup();
            manageClass.clickManageDetails();
            manageClass.isDispalyedUpdateList();
            manageClass.clickDropDown();
            WebElement webElement = driver.findElement(By.xpath("//*[@id=\"k-tabstrip-tabpanel-0\"]/form/div[2]/kendo-floatinglabel/kendo-dropdownlist"));
            Select select = new Select(webElement);
            select.selectByValue("Year "+index+"");
            manageClass.clickSave();
        }

        driver.navigate().refresh();
        String text=  driver.findElement(By.xpath("(//div[@class=\"grade-chip ltr\"])[11]")).getText();
        Assert.assertEquals("Year 5",text);
    }
     
}
