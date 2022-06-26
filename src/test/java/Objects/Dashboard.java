package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    WebDriver driver;
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    By closeBtn = By.xpath("//button[@class='close-icon-container']");

    public void clickCloseBtn(){
        driver.findElement(closeBtn).click();
    }
}
