package stepDefinitions;

import cucumber.api.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import com.pastbook.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Set;



@RunWith(Cucumber.class)
public class CommonSteps extends BaseClass {
    WebDriver driver;
    HomePageObjects homePageObjects;
    SignInWindowPageObjects windowPageObjects;
    CreatePastBookPageObjects createPastBookPageObjects;
    UploadPicturesPageObjects uploadPicturesPageObjects;
    ProfilePageObjects profilePageObjects;

    @Given("^I am in Pastbook Home Page$")
    public void i_am_in_Pastbook_Home_Page() throws Throwable {
        driver=getDriver();
        initPercy(driver,"HomePage",null);
    }

    @When("^I click on sign in menu$")
    public void i_click_on_sign_in_menu() throws Throwable {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.getSignInMenu().click();
    }

    @When("^I navigated to sign in popup screen$")
    public void i_navigated_to_sign_in_popup_screen() throws Throwable {
        String parentWindow = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();

        for (String tab:tabs){
            if (!tab.equals(parentWindow)){
                driver.switchTo().window(tab);
                driver.manage().window().maximize();
            }
        }
    }

    @When("^I click on use email option$")
    public void i_click_on_use_email_option() throws Throwable {
        windowPageObjects = new SignInWindowPageObjects(driver);

        windowPageObjects.getEmailSignIn().click();
    }

    @When("^I enter the (.*) to the email text box$")
    public void i_enter_the_test_email_com_to_the_email_text_box(String email) throws Throwable {
        windowPageObjects.getEmailTextBox().sendKeys(email);
    }

    @When("^I click on submit button$")
    public void i_click_on_submit_button() throws Throwable {
        windowPageObjects.getSubmitButton().click();
    }

    @When("^I enter the (.*) on the password text box$")
    public void i_enter_the_password_text_box(String password) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(windowPageObjects.waitForPassword()));

        windowPageObjects.getPasswordTextBox().sendKeys(password);
    }

    @Then("^I get re-directed to Home Page as a Logged in User$")
    public void i_get_re_directed_to_Home_Page_as_a_Logged_in_User() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBe(windowPageObjects.waitForLogin(),"You are in! Ready to go."));
    }

    @When("^I click on create menu option$")
    public void i_click_on_create_menu_option() throws IOException {
        homePageObjects.getCreateMenuItem().click();
    }
    @When("^I get navigated to create Past Book Page$")
    public void i_get_navigated_to_create_book_page(){
        createPastBookPageObjects = new CreatePastBookPageObjects(driver);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(createPastBookPageObjects.waitTitle()));
    }
    @When("^I enter (.*) into Title text field$")
    public void i_enter_title_into_field(String title){
        createPastBookPageObjects.getTitleTxt().sendKeys(title);
    }
    @When("^I click on option link text$")
    public void i_click_on_option_link_text(){
        createPastBookPageObjects.getOptionLinkTxt().click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(createPastBookPageObjects.waitAddCover()));
    }
    @When("^I click on Add Cover Button$")
    public void i_click_on_add_cover_button(){
        createPastBookPageObjects.getAddCoverBtn().click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(createPastBookPageObjects.waitDragNDrop()));
    }
    @When("^I add a cover photo (.*)$")
    public void i_add_a_cover_photo(String file) throws IOException, InterruptedException {
        createPastBookPageObjects.getFileUploader().sendKeys(getImagePath(file));

        Thread.sleep(5000);

        createPastBookPageObjects.getUploadButton().click();
    }
    @Then("^I click on create your Pastbook button$")
    public void i_click_on_create_pastbook_button() throws InterruptedException {
        Thread.sleep(5000);

        createPastBookPageObjects.getCreateBookBtn().click();
    }

    @And("^I close pop-up advertisement$")
    public void iClosePopUpAdvertisement() {
        WebDriverWait wait= new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(createPastBookPageObjects.waitAd()));

        createPastBookPageObjects.getPopUpAd().click();
    }

    @When("^I click on upload picture$")
    public void iClickOnUploadPicture() {
        uploadPicturesPageObjects = new UploadPicturesPageObjects(driver);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(uploadPicturesPageObjects.waitTillUploadImg()));

        uploadPicturesPageObjects.getUploadPictureBtn().click();

        WebDriverWait wait2 = new WebDriverWait(driver,30);
        wait2.until(ExpectedConditions.elementToBeClickable(uploadPicturesPageObjects.waitTillDragNDrop()));
    }

    @And("^I add album photo (.*) and click on upload$")
    public void iAddAlbumPhotoImgAndImgAndClickOnUpload(String imagePath1) {

        uploadPicturesPageObjects.getFileUploader().sendKeys(getImagePath(imagePath1));
        uploadPicturesPageObjects.getUploadBtn().click();
    }

    @Then("^I click on continue button$")
    public void iClickOnContinueButton() throws InterruptedException {
        Thread.sleep(10000);

        uploadPicturesPageObjects.getContinueBtn().click();
    }

    @And("^I logout from pastbook application$")
    public void iSeePublishedBookPage() {
        driver.navigate().to("https://moments.pastbook.com/signin/signout");
        driver.close();
    }

    @And("^I navigated to profile$")
    public void iNavigatedToProfile() {
        windowPageObjects.getHamburgerIcon().click();

        WebDriverWait wait= new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(windowPageObjects.waitProfileIconAppear()));

        driver.navigate().to("https://moments.pastbook.com/user/profile/");
    }

    @And("^I reset the password to (.*)$")
    public void iResetThePasswordToPassword(String password) {
        profilePageObjects = new ProfilePageObjects(driver);

        profilePageObjects.getUpdatePasswordLink().click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePageObjects.waitTillNewPasswordTxtAppear()));

        profilePageObjects.getNewPasswordTxt().sendKeys(password);
        profilePageObjects.getConfirmPasswordTxt().sendKeys(password);
    }

    @Then("^I click on save password button$")
    public void iClickOnSavePasswordButton() {
        profilePageObjects.getSavePasswordBtn().click();
    }
}
