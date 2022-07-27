package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;


public class ProfilePage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Profile elements
    @FindBy(xpath = "//div[@class='user-interface-in-head']//img[contains(@alt,'')]/parent::div")
    WebElement profileIcon;

    @FindBy(xpath = "(//*[contains(text(),'View Profile')])[3]")
    WebElement viewProfileLink;

    @FindBy(xpath = "//span[contains(text(),'Change cover')]")
    WebElement changeCoverLink;

    @FindBy(xpath = "//div[@class='hidden']")
    WebElement coverPhotoInput;

    @FindBy(xpath = "//*[contains(text(),'Apply')]")
    WebElement applyButton;

    @FindBy(xpath = "//img[@class='cover_img']")
    WebElement coverPhoto;

    @FindBy(xpath = "(//i[@class='material-icons edit_icon'][normalize-space()='edit'])[1]")
    WebElement editProfilePicture;

    @FindBy(xpath = "((//*[contains(text(), \"Edit Profile Picture\")]/parent::div/parent::div/parent::div/child::div/child::div)[2]/child::form/child::div/child::div/child::div)[2]/child::div")
    List<WebElement> avatars;

    @FindBy(xpath = "//h4[normalize-space()='About Me']/parent::div//i")
    WebElement aboutMeEditIcon;

    @FindBy(xpath = "//div[contains(text(),'Edit Profile')]")
    WebElement editProfileHeader;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//textarea[@class='custom-textarea']")
    WebElement aboutMeTextArea;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "(//*[contains(text(), \"Interest\")]/parent::div/child::div/child::button)[2]")
    WebElement interestsEditIcon;

    @FindBy(xpath = "//div[contains(text(),'Edit Interests')]")
    WebElement editInterestsHeader;

    @FindBy(xpath = "//div[@class='bx-interests']/child::div/child::div")
    List<WebElement> interests;

    @FindBy(xpath = "//h4[normalize-space()='Industry']/parent::div//i")
    WebElement industryEditIcon;

    @FindBy(xpath = "//textarea[@name='pref_work_area']")
    WebElement workAreaTextArea;

    @FindBy(xpath = "//div[contains(text(),'Select Industry')]")
    WebElement selectIndustryHeader;

    @FindBy(xpath = "//h3[contains(text(),'Edit Profile Picture')]")
    WebElement editProfilePictureHeader;

    @FindBy(xpath = "//div[contains(text(),'Cover Picture')]")
    WebElement coverPictureHeader;

    @FindBy(xpath = "//h4[normalize-space()='Skills']/parent::div//i")
    WebElement skillsEditIcon;

    @FindBy(xpath = "//*[@placeholder='Required Skills']")
    WebElement requiredSkillsInput;

    @FindBy(xpath = "//*[@placeholder='Required Skills']/parent::div/parent::div/following-sibling::div//li")
    List<WebElement> requiredSkills;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//*[contains(text(),'Edit Skills')]")
    WebElement editSkillsHeader;


    @FindBy(xpath = "//h4[normalize-space()='Language']/parent::div//i")
    WebElement languageEditIcon;

    @FindBy(xpath = "//*[contains(text(),'Edit Languages')]")
    WebElement editLanguagesHeader;


    @FindBy(xpath = "//*[@placeholder='Required Language']/parent::div/parent::div/following-sibling::div//li")
    List<WebElement> languages;


    @FindBy(xpath = "//*[@placeholder='Required Language']")
    WebElement requiredLanguageInput;


    @FindBy(xpath = "//h4[normalize-space()='Hourly Rate']/parent::div//i")
    WebElement hourlyRateEditIcon;

    @FindBy(xpath = "//*[contains(text(),'Edit Rate')]")
    WebElement editRateHeader;

    @FindBy(xpath = "//input[@id='rateHourly']")
    WebElement hourlyRateInput;

    @FindBy(xpath = "//input[@id='rateMontly']")
    WebElement rateMonthlyInput;

    @FindBy(xpath = "//textarea[@name='rateNote']")
    WebElement rateNoteTextArea;

    @FindBy(xpath = "//button[normalize-space()='+ Add new category']")
    WebElement addNewCategoryButton;

    @FindBy(xpath = "//*[contains(text(), \"Create portfolio category\")]")
    WebElement createPortfolioCategoryHeader;

    @FindBy(xpath = "//input[@id='name']")
    WebElement categoryNameInput;







    // END: Profile elements



    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkProfilePageIsLoaded() {
    	try {
    		int step = 0;

    		driverActions.clickOnWebElementWithActionsClass(profileIcon);
    		step++;
    		System.out.println("Step " + step + ": Click on profile link");

    		driverActions.clickOnWebElementWithActionsClass(viewProfileLink);
    		step++;
    		System.out.println("Step " + step + ": Click on view profile link");

    		return driverWaits.waitUntilVisible(20, changeCoverLink);
    	}
    	catch (Exception e) {
    		return false;
    	}
    }

    public boolean changeCoverPhoto() {
    	try {
    		int step = 0;


            URLConnection urlConnection = new URL(coverPhoto.getAttribute("src")).openConnection();
            int imageSize = urlConnection.getContentLength();

    		driverActions.clickOnWebElementWithActionsClass(changeCoverLink);
    		step++;
    		System.out.println("Step " + step + ": Click on profile link");

//            Assert.assertTrue(driverWaits.waitUntilVisible(20, coverPictureHeader));
            driverWaits.waitThreeSeconds();

    		driverActions.uploadImage(coverPhotoInput, TestData.getRandomImage());
    		step++;
    		System.out.println("Step " + step + ": upload random image from directory");
            driverWaits.waitThreeSeconds();

            driverActions.clickOnWebElementWithActionsClass(applyButton);
            step++;
            System.out.println("Step " + step + ": Click on apply button");

            urlConnection = new URL(coverPhoto.getAttribute("src")).openConnection();
            int newImageSize = urlConnection.getContentLength();

            return driverActions.waitUntilInvisibilityOfElement(coverPictureHeader);

    	}
    	catch (Exception e) {
    		return false;
    	}
    }

    public boolean changeProfilePicture() {

        try {
            int step = 0;

            URLConnection urlConnection = new URL(coverPhoto.getAttribute("src")).openConnection();
            String imageTitle = urlConnection.getURL().getFile();
            System.out.println("imageTitle: " + imageTitle);

            driverActions.clickOnWebElementWithActionsClass(editProfilePicture);
            step++;
            System.out.println("Step " + step + ": Click on edit profile picture link");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, editProfilePictureHeader));

            driverActions.clickOnWebElementWithActionsClass(avatars.get(RandomUtils.nextInt(avatars.size()-1)));
            step++;
            System.out.println("Step " + step + ": Click on random avatar");

            driverActions.clickOnWebElementWithActionsClass(applyButton);
            step++;
            System.out.println("Step " + step + ": Click on apply button");

            urlConnection = new URL(coverPhoto.getAttribute("src")).openConnection();
            String newImageTitle = urlConnection.getURL().getFile();
            System.out.println("imageTitle: " + imageTitle);

            return driverActions.waitUntilInvisibilityOfElement(editProfilePictureHeader);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateAboutMeSection() {
        //TODO: On Webpage the functionality has issue with the "About me" section. 27-05-2022
        try {
            int step = 0;

            driverWaits.waitOneSeconds();
            driverActions.clickOnWebElementWithActionsClass(aboutMeEditIcon);
            step++;
            System.out.println("Step " + step + ": Click on edit icon");

            boolean result = driverWaits.waitUntilVisible(20, editProfileHeader);

            driverActions.refreshPage();

            return result;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateInterests() {

        try {
            int step = 0;

            driverWaits.waitThreeSeconds();
            driverActions.clickOnWebElementWithActionsClass(interestsEditIcon);
            step++;
            System.out.println("Step " + step + ": Click on edit icon");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, editInterestsHeader));

            for(int i = 0; i < 6; i++) {
                driverActions.clickOnWebElementWithActionsClass(interests.get(RandomUtils.nextInt(interests.size()-1)));
                step++;
                System.out.println("Step " + step + ": selecting random interests");
            }

            driverWaits.waitThreeSeconds();
            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println("Step " + step + ": Click on save button");

            return driverActions.waitUntilInvisibilityOfElement(editInterestsHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateIndustrySettings() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(industryEditIcon);
            step++;
            System.out.println("Step " + step + ": Click on edit icon");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, selectIndustryHeader));

            String text = TestData.getRandomFirstName();

            driverActions.typeText(workAreaTextArea, text);
            step++;
            System.out.println("Step " + step + ": Type text in work area text area");

            driverActions.clickOnWebElementWithActionsClass(applyButton);
            step++;
            System.out.println("Step " + step + ": Click on apply button");

            return driverActions.waitUntilInvisibilityOfElement(selectIndustryHeader);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateSkills() {

        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(skillsEditIcon);
            step++;
            System.out.println("Step " + step + ": Click on edit icon");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, editSkillsHeader));

            driverActions.clickOnWebElementWithActionsClass(requiredSkillsInput);
            step++;
            System.out.println("Step " + step + ": Click on required skills input");

            driverWaits.waitThreeSeconds();
            driverActions.clickOnWebElementWithActionsClass(requiredSkills.get(RandomUtils.nextInt(requiredSkills.size() - 1)));
            step++;
            System.out.println("Step " + step + ": Selecting random required skill");

            driverActions.clickOnWebElementWithActionsClass(addButton);
            step++;
            System.out.println("Step " + step + ": Click on add button");

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println("Step " + step + ": Click on save button");

            return driverActions.waitUntilInvisibilityOfElement(editSkillsHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateLanguages() {

        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(languageEditIcon);

            step++;
            System.out.println("Step " + step + ": Click on edit icon");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, editLanguagesHeader));

            driverActions.clickOnWebElementWithActionsClass(requiredLanguageInput);
            step++;
            System.out.println("Step " + step + ": Click on add language button");

            driverWaits.waitFiveSeconds();
            driverActions.clickOnWebElementWithActionsClass(languages.get(RandomUtils.nextInt(languages.size() - 1)));
            step++;
            System.out.println("Step " + step + ": Selecting random language");

            driverActions.clickOnWebElementWithActionsClass(addButton);
            step++;
            System.out.println("Step " + step + ": Click on add button");

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println("Step " + step + ": Click on save button");

            return driverActions.waitUntilInvisibilityOfElement(editLanguagesHeader);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateRate() {

        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(hourlyRateEditIcon);
            step++;
            System.out.println("Step " + step + ": Click on edit icon");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, editRateHeader));

            driverActions.typeText(hourlyRateInput, TestData.getRandomDigits(2));
            step++;
            System.out.println("Step " + step + ": Click on rate input");

            driverActions.typeText(rateMonthlyInput, TestData.getRandomDigits(3));
            step++;
            System.out.println("Step " + step + ": Click on monthly rate input");

            driverActions.typeText(rateNoteTextArea, TestData.getRandomParagraph());
            step++;
            System.out.println("Step " + step + ": Click on rate note text area");

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println("Step " + step + ": Click on save button");

            return driverActions.waitUntilInvisibilityOfElement(editRateHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addNewCategory() {

        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(addNewCategoryButton);
            step++;
            System.out.println("Step " + step + ": Click on add new category button");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, createPortfolioCategoryHeader));

            driverActions.clickOnWebElementWithActionsClass(categoryNameInput);
            driverActions.typeText(categoryNameInput, TestData.getRandomWord());
            step++;
            System.out.println("Step " + step + ": Type random category name");

            driverWaits.waitThreeSeconds();
            driverActions.clickOnWebElementWithActionsClass(applyButton);
            step++;
            System.out.println("Step " + step + ": Click on apply button");

            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}