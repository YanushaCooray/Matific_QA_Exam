package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    WebDriver driver;
    public Home(WebDriver driver){
        this.driver = driver;
    }

    By loginBtn = By.xpath("//a[@id='login-button']");
    public  void clickLogInBtn(){
        driver.findElement(loginBtn).click();
    }
}
