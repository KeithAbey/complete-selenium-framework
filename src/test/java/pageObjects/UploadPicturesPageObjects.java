package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class UploadPicturesPageObjects {
    WebDriver driver;

    public UploadPicturesPageObjects(WebDriver driver){
        this.driver=driver;
    }

    By uploadPictureBtn = By.linkText("Upload your pictures");
    By fileUploader = By.id("fsp-fileUpload");
    By dragNdropArea = By.xpath("//div[@id='__filestack-picker']/div/div/div/div[2]/div[2]/div/div/div");
    By uploadBtn = By.xpath("//div[@id='__filestack-picker']/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/span[3]/span");
    By continueBtn = By.xpath("//*[@id='add']/div[9]/div/div/div[3]/button[2]");

    public WebElement getUploadPictureBtn(){
        return driver.findElement(uploadPictureBtn);
    }
    public WebElement getFileUploader(){
        return driver.findElement(fileUploader);
    }
    public By waitTillDragNDrop(){
        return dragNdropArea;
    }
    public WebElement getUploadBtn(){
        return driver.findElement(uploadBtn);
    }
    public WebElement getContinueBtn(){
        return driver.findElement(continueBtn);
    }
    public By waitTillUploadImg(){
        return uploadPictureBtn;
    }
    public By waitTillUpload(){
        return uploadBtn;
    }

}
