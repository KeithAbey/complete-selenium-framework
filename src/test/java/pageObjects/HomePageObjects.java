package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePageObjects {
    WebDriver driver;

    public HomePageObjects(WebDriver driver){
        this.driver=driver;
    }

    By signInMenu = By.id("nav-item-signin");
    By createMenuItem = By.xpath("//*[@id='nav-item-create']/a");

    public WebElement getSignInMenu (){
        return driver.findElement(signInMenu);
    }
    public WebElement getCreateMenuItem(){
        return driver.findElement(createMenuItem);
    }

}
