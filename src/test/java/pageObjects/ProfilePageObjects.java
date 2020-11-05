package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ProfilePageObjects {
    WebDriver driver;
    public ProfilePageObjects(WebDriver driver){
        this.driver=driver;
    }

    By updatePasswordLink = By.linkText("Update your password »");
    By newPasswordTxt = By.xpath("//*[@id='formUserPassword']/div[1]/div/input");
    By confirmPasswordTxt = By.xpath("//*[@id='formUserPassword']/div[2]/div/input");
    By savePasswordBtn = By.xpath("//*[@id='formUserPassword']/div[3]/button");

    public WebElement getUpdatePasswordLink(){
        return driver.findElement(updatePasswordLink);
    }
    public WebElement getNewPasswordTxt(){
        return driver.findElement(newPasswordTxt);
    }
    public WebElement getConfirmPasswordTxt(){
        return driver.findElement(confirmPasswordTxt);
    }
    public WebElement getSavePasswordBtn(){
        return driver.findElement(savePasswordBtn);
    }
    public By waitTillNewPasswordTxtAppear(){
        return newPasswordTxt;
    }
}
