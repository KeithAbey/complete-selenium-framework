package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SignInWindowPageObjects {
    WebDriver driver;
    public SignInWindowPageObjects(WebDriver driver){
        this.driver=driver;
    }

    By emailOption = By.xpath("//*[@class='facebook-login']/div[2]/a");
    By emailTextBox = By.xpath("//*[@name='email']");
    By passwordTextBox = By.xpath("//*[@name='password']");
    By submitButton = By.xpath("//*[@class='input-group-btn']/button");
    By successPlaceHolder = By.xpath("//*[@class='container']/h2");
    By hamburgerIcon = By.xpath("//*[@id='signin']/nav/header/ul[1]/li/a/span/span");
    By profileMenuIcon = By.linkText("Profile");

    public WebElement getEmailSignIn(){
        return driver.findElement(emailOption);
    }
    public WebElement getEmailTextBox(){
        return driver.findElement(emailTextBox);
    }
    public WebElement getSubmitButton(){
        return driver.findElement(submitButton);
    }
    public WebElement getPasswordTextBox(){
        return driver.findElement(passwordTextBox);
    }
    public By waitProfileIconAppear(){
        return profileMenuIcon;
    }
    public By waitForPassword(){
        return passwordTextBox;
    }
    public By waitForLogin(){
        return successPlaceHolder;
    }
    public WebElement getHamburgerIcon(){
        return driver.findElement(hamburgerIcon);
    }
    public WebElement getProfileMenuIcon(){
        return driver.findElement(profileMenuIcon);
    }
}
