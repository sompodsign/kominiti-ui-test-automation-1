package main.java.testcases;

import DataModel.TestDataModel;
import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pages.PagesFactory;


@SuppressWarnings("ThrowablePrintedToSystemOut")
public class HomepageTest extends BaseTest {
    @SuppressWarnings("unused")
    HomePage homePage;

    @Test(priority = 1)
    public void validateHomePageLoadSuccessfully() {
        try {
            initializeTest("Homepage loading test", "This test verifies that the homepage is loaded successfully", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.checkHomePageLoaded();
            Assert.assertTrue(result, "Homepage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateUserCanShareTextOnTimeline() {
        try {
            initializeTest("User can share text on timeline", "This test verifies that the user can share text on timeline", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.shareTextOnTimeline();

            Assert.assertTrue(result, "Text is not shared on timeline");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateUserCanShareTextOnTimelineWithImage() {
        try {
            initializeTest("User can share text on timeline with image", "This test verifies that the user can share text on timeline with image", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.shareTextOnTimelineWithImage();

            Assert.assertTrue(result, "Text is not shared on timeline with image");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateUserCanShareVideosOnTimeline() {
        try {
            initializeTest("User can share videos on timeline", "This test verifies that the user can share videos on timeline", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.shareVideoOnTimeline();

            Assert.assertTrue(result, "Video is not shared on timeline");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateUserCanWriteArticleAndShare() {
        try {
            initializeTest("User can write article and share", "This test verifies that the user can write article and share", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.writeArticleAndShare();

            Assert.assertTrue(result, "Article is not shared on timeline");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void validateUserCanSeeTrendingTopics() {

        try {
            initializeTest("User can see trending topics", "This test verifies that the user can see trending topics", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.checkTrendingTopics();

            Assert.assertTrue(result, "Trending topics are not displayed");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 7)
    public void validateSuggestedGroupViewAllButtonFunctionality() {

        try {
            initializeTest("Suggested Group View All button functionality test", "This test verifies that the Suggested Group View All button functionality works", "Sanity Test");

            homePage = PagesFactory.getHomePage();
            boolean result = homePage.checkSuggestedGroupViewAllButtonFunctionality();

            Assert.assertTrue(result, "Suggested Group View All button functionality is not working");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void validateViewAllUsersButtonFunctionality() {
        try {
            initializeTest("View All Users button functionality test", "This test verifies that the View All Users button functionality works", "Sanity Test");

            homePage = PagesFactory.getHomePage();
            boolean result = homePage.checkViewAllUsersButtonFunctionality();

            Assert.assertTrue(result, "View All Users button functionality is not working");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9)
    public void validateUserCanScrollThroughPostsAndNewPostsLoad() {
        try {
            initializeTest("User can scroll through posts and new posts load", "This test verifies that the user can scroll through posts and new posts load", "Sanity Test");

            homePage = PagesFactory.getHomePage();
            boolean result = homePage.checkScrollThroughPostsAndNewPostsLoad();

            Assert.assertTrue(result, "New posts are not loaded");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void validateUserCanLikeAPost() {

        try {
            initializeTest("User can like a post", "This test verifies that the user can like a post", "Sanity Test");

            homePage = PagesFactory.getHomePage();
            boolean result = homePage.checkLikeAPost();

            Assert.assertTrue(result, "Post is not liked");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}