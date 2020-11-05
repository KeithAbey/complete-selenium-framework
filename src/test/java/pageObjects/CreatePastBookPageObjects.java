package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CreatePastBookPageObjects {
    WebDriver driver;

    public CreatePastBookPageObjects(WebDriver driver){
        this.driver=driver;
    }

    By titleField = By.xpath("//*[@name='title']");
    By optionLink = By.linkText("Options »");
    By addCoverBtn = By.xpath("//*[@id='bookOptions']/div[2]/div/div[2]/button[1]");
    By createBookBtn = By.xpath("//*[@id='create-button']");
    By dragNdropArea = By.xpath("//div[@id='__filestack-picker']/div/div/div/div[2]/div[2]/div/div/div");
    By fileUploader = By.id("fsp-fileUpload");
    By uploadButton = By.xpath("//*[@id='__filestack-picker']/div/div/div[1]/div[2]/div[2]/div/div[3]/div/span[3]/div/span");
    By closepopupad = By.xpath("//*[@id='createOptions']/div/div/button/span");

    public WebElement getTitleTxt(){
        return driver.findElement(titleField);
    }
    public By waitTitle(){
        return titleField;
    }
    public WebElement getOptionLinkTxt(){
        return driver.findElement(optionLink);
    }
    public WebElement getAddCoverBtn(){
        return driver.findElement(addCoverBtn);
    }
    public WebElement getCreateBookBtn(){
        return driver.findElement(createBookBtn);
    }
    public By waitAddCover(){
        return addCoverBtn;
    }
    public By waitDragNDrop(){
        return dragNdropArea;
    }
    public WebElement getDragNDropArea(){
        return driver.findElement(dragNdropArea);
    }
    public WebElement getFileUploader(){
        return driver.findElement(fileUploader);
    }
    public WebElement getUploadButton(){
        return driver.findElement(uploadButton);
    }
    public By waitTillUpload(){
        return uploadButton;
    }
    public WebElement getPopUpAd(){
        return driver.findElement(closepopupad);
    }
    public By waitCreateButton(){
        return createBookBtn;
    }
    public By waitAd(){
        return closepopupad;
    }
}
