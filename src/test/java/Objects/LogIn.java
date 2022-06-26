package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
    WebDriver driver;
    public LogIn(WebDriver driver){
        this.driver = driver;
    }
    By userNameInput = By.xpath("//input[@id='username-input']");
    By passwordInput = By.xpath("//input[@id='password-input']");
    By continueBtn = By.xpath("//span[@id='login-text']");
    By loginBtn = By.xpath("//span[@id=\"login-text\"]");
    public  void enterUserName(String userName){
        driver.findElement(userNameInput).sendKeys(userName);
    }
    public  void  clickContinueBtn(){
        driver.findElement(continueBtn).click();
    }
    public void enterPassword(String paaword){
        driver.findElement(passwordInput).sendKeys(paaword);
    }
    public  void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
}
