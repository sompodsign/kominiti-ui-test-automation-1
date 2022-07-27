package pageobjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import pages.PagesFactory;

import DataModel.TestDataModel;
import testdata.TestData;


public class HomePage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Homepage elements
    @FindBy(xpath = "//div[@class='form-control share-post']")
    WebElement sharePostButton;

    @FindBy(xpath = "//textarea[@placeholder='Share what is on your mind...']")
    WebElement sharePostTextArea;

    @FindBy(xpath = "//span[normalize-space()='Images']/following-sibling::input")
    WebElement imageUploadInput;

    @FindBy(xpath = "//input[@id='File']")
    WebElement videoUploadInput;

    @FindBy(xpath = "//button[@class='btn btn-post waves-effect waves-light']")
    WebElement postButton;

    @FindBy(xpath = "//div[@class='media-uploaded']")
    List<WebElement> uploadedImages;

    @FindBy(xpath = "//span[normalize-space()='a few seconds ago']")
    WebElement aFewSecondsAgo;

    @FindBy(xpath = "//span[normalize-space()='Write an article']")
    WebElement writeArticleButton;

    @FindBy(xpath = "//span[contains(text(), \"Change cover\")]/following-sibling::input")
    WebElement articleCover;

    @FindBy(xpath = "//textarea[@id='headline']")
    WebElement articleHeadline;

    @FindBy(xpath = "//div[@aria-label='write here..']")
    WebElement writeArticleTextArea;

    @FindBy(xpath = "//input[@placeholder='Paste the links here and press Enter to Add']")
    WebElement pasteLinkInput;

    @FindBy(xpath = "//span[@class='btn btn-round-link btn-icon-file']//input[@type='file']")
    WebElement articleImageUploadField;

    @FindBy(xpath = "//span[@class='btn btn-round-link btn-icon-file btn-video-attchment']//input[@type='file']")
    WebElement articleVideoUploadField;

    @FindBy(xpath = "//span[normalize-space()='Publish']")
    WebElement publishButton;

    @FindBy(xpath = "//*[contains(text(), \"Article published successfully\")]")
    WebElement articlePublishedSuccessfullyMessage;

    @FindBy(xpath = "//span[normalize-space()='Trending topics']")
    WebElement trendingTopics;

    @FindBy(xpath = "//h3[normalize-space()='Top Trending Topics Of The Day']")
    WebElement topTrendingTopicsOfTheDay;

    @FindBy(xpath = "//button[normalize-space()='View more']")
    WebElement viewMoreButton;

    @FindBy(xpath = "//span[normalize-space()='Wall of fame']")
    WebElement wallOfFame;

    @FindBy(xpath = "//div[@class='left-sidebar scroll-content']//button[contains(text(),'View all')]")
    WebElement viewAllSuggestedGroupButton;

    @FindBy(xpath = "//span[normalize-space()='Networking Groups']")
    WebElement networkingGroups;

    @FindBy(xpath = "(//button[contains(text(),'View all')])[3]")
    WebElement viewAllUsersButton;

    @FindBy(xpath = "//h3[normalize-space()='People you may know based on your interest']")
    WebElement peopleYouMayKnowBasedOnYourInterest;

    @FindBy(xpath = "//span[normalize-space()='Wall']")
    WebElement wall;

    @FindBy(xpath = "//*[contains(text(), \"Like\")]/parent::a/parent::div/parent::div/parent::div/parent::div")
    List <WebElement> posts;


    @FindBy(xpath = "//div[@id='_page-content_']")
    WebElement pageContent;

    @FindBy(xpath = "//*[contains(text(), \"Please wait data is loading\")]")
    WebElement pleaseWaitDataIsLoading;

    @FindBy(xpath = "//*[contains(text(),'Comment')]")
    WebElement commentButton;

    @FindBy(xpath = "//textarea[@placeholder='Write a comment']")
    WebElement commentTextArea;





    // END: Homepage elements



    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkHomePageLoaded() {
        try {
            System.out.println("Checking Home Page loaded");
            return driverWaits.waitUntilVisible(10, sharePostButton);
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean shareTextOnTimeline() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

            String text = TestData.getRandomWord();
            driverActions.typeText(sharePostTextArea, text);
            step++;
            System.out.println("Step " + step + ": Type text: " + text);

            return driverWaits.isElementVisibleWithText(20, text);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean shareTextOnTimelineWithImage() {
        try {

            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

//            driverWaits.waitOneSeconds();
            String text = TestData.getRandomWord();
            driverActions.clickOnWebElementWithActionsClass(sharePostTextArea);
            driverActions.typeText(sharePostTextArea, text);
            step++;
            System.out.println("Step " + step + ": Type text: " + text);

            driverActions.uploadImage(imageUploadInput, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload image");
            driverWaits.waitFiveSeconds();

            driverActions.clickOnWebElementWithActionsClass(postButton);
            step++;
            System.out.println("Step " + step + ": Click on post button");

            return driverWaits.waitUntilVisible(30, (WebElement) By.xpath("//*[normalize-space()='" + text + "']"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean shareVideoOnTimeline() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

            driverActions.upload(videoUploadInput, ApplicationSettings.getVideoFolderPath(), TestData.getRandomVideo());
            step++;
            System.out.println("Step " + step + ": Upload video");
            driverWaits.waitFiveSeconds();

            driverActions.clickOnWebElementWithActionsClass(postButton);
            step++;
            System.out.println("Step " + step + ": Click on post button");

            return driverWaits.waitUntilVisible(25, aFewSecondsAgo);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean writeArticleAndShare() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(writeArticleButton);
            step++;
            System.out.println("Step " + step + ": Click on write article button");

            driverWaits.waitUntilVisible(10, articleCover);
            driverActions.uploadImage(articleCover, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload image");

            driverActions.typeText(articleHeadline, TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Type text: headline");

            driverActions.typeText(writeArticleTextArea, TestData.getRandomParagraph());
            step++;
            System.out.println("Step " + step + ": Type text: text");

            driverActions.uploadImage(articleImageUploadField, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload image");

            driverActions.upload(articleVideoUploadField, ApplicationSettings.getVideoFolderPath(), TestData.getRandomVideo());
            step++;
            System.out.println("Step " + step + ": Upload video");

            driverActions.clickOnWebElementWithActionsClass(publishButton);
            step++;
            System.out.println("Step " + step + ": Click on publish button");

            return driverWaits.waitUntilVisible(30, articlePublishedSuccessfullyMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkTrendingTopics() {
        try {
            int step;

            step = 0;

            driverActions.clickOnWebElementWithActionsClass(trendingTopics);
            step++;
            System.out.println("Step " + step + ": Click on trending topics");

            boolean result = driverWaits.waitUntilVisible(10,topTrendingTopicsOfTheDay);

            driverActions.clickOnWebElementWithActionsClass(wall);
            step++;
            System.out.println("Step " + step + ": Click on wall");

            return result;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkSuggestedGroupViewAllButtonFunctionality() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(viewAllSuggestedGroupButton);
            step++;
            System.out.println("Step " + step + ": Click on view all suggested group button");

            boolean result = driverWaits.waitUntilVisible(20, networkingGroups);
            driverActions.browserBack();
            step++;

            System.out.println("Step " + step + ": Browser back");

            return result;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkViewAllUsersButtonFunctionality() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(viewAllUsersButton);
            step++;
            System.out.println("Step " + step + ": Click on view all users button");

            boolean result = driverWaits.waitUntilVisible(20, peopleYouMayKnowBasedOnYourInterest);
            driverActions.browserBack();
            step++;

            System.out.println("Step " + step + ": Browser back");

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkScrollThroughPostsAndNewPostsLoad() {

        try {
            int step;
            step = 0;

            driverWaits.waitUntilVisible(20, pleaseWaitDataIsLoading);
            driverActions.waitUntilInvisibilityOfElement(pleaseWaitDataIsLoading);
            step++;
            System.out.println("Step " + step + ": Wait until please wait data is loading");

            int amountOfPosts = posts.size();


            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (WebElement post : posts) {
                js.executeScript("arguments[0].scrollIntoView();", post);
                step++;
                System.out.println("Step " + step + ": Scroll through posts");
                driverWaits.waitOneSeconds();
            }

            try{
                driverWaits.waitUntilVisible(10, pleaseWaitDataIsLoading);
            }
            catch (Exception e){
                System.out.println("No new posts");
            }

            driverActions.waitUntilInvisibilityOfElement(pleaseWaitDataIsLoading);

            List<WebElement> amountOfNewPosts = driver.findElements(By.xpath("//*[contains(text(), \"Like\")]/parent::a/parent::div/parent::div/parent::div/parent::div"));

            return amountOfPosts < amountOfNewPosts.size();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkLikeAPost() {

        try {
            int step = 0;

            driverWaits.waitUntilVisible(20, pleaseWaitDataIsLoading);
            driverActions.waitUntilInvisibilityOfElement(pleaseWaitDataIsLoading);

            System.out.println(posts);
            System.out.println(posts.get(0));

            driverActions.scrollToWebElementWithJavaScriptWithoutCheckingVisibility(posts.get(0));
            step++;
            System.out.println("Step " + step + ": Scroll to first post");

            WebElement likeButton = posts.get(0).findElement(By.xpath("//*[contains(text(),'Like')]"));
            driverActions.clickOnWebElementWithActionsClass(likeButton);
            step++;
            System.out.println("Step " + step + ": Click on like button");

            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}