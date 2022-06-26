package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageClass {
    WebDriver driver;
    public ManageClass(WebDriver driver){
        this.driver = driver;
    }

    By classManagementList = By.xpath("//li[@class='nav-item item-dropdown ng-star-inserted dropdown']");
    By popUp = By.xpath("(//button[@data-test=\"classSummaryCardKebabMenuToggle\"])[11]");

    By manageDetails = By.xpath("//span[@data-test=\"ITM_MANAGE_CLASS_DETAILS\"]");

    By updateList = By.xpath("//div[@id=\"k-tabstrip-tabpanel-0\"]");
    By dropDown = By.xpath("//*[@id=\"d875be85-c221-4247-aeac-98e5e1be97e7\"]");
    By saveBtn = By.xpath("//button[text()='Save']");
    public void isDisplayedClassManagementList(){
        driver.findElement(classManagementList).isDisplayed();
    }
    public  void clickPopup (){
        driver.findElement(popUp).click();
    }
    public void clickManageDetails(){
        driver.findElement(manageDetails).click();
    }
    public void isDispalyedUpdateList(){
        driver.findElement(updateList).isDisplayed();
    }
    public void clickDropDown(){
        driver.findElement(dropDown).click();
    }
    public void clickSave(){
        driver.findElement(saveBtn).click();
    }

}
