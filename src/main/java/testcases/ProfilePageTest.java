package main.java.testcases;

import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pageobjects.ProfilePage;
import pages.PagesFactory;


public class ProfilePageTest extends BaseTest {
    ProfilePage profilePage;

    @Test(priority = 1)
    public void validateProfilePageLoadsSuccessfully() {
        try {
            initializeTest("Profile page loading test", "This test verifies that the Profile page is loaded successfully", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.checkProfilePageIsLoaded();
            Assert.assertTrue(result, "Profile page is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateUserCanChangeTheirCoverPhoto() {

        try {
            initializeTest("Profile page cover photo test", "This test verifies that the user can change their cover photo", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.changeCoverPhoto();

            Assert.assertTrue(result, "User is not able to change their cover photo");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateUsersCanChangeTheirProfilePicture() {

        try {
            initializeTest("Profile page profile picture test", "This test verifies that the user can change their profile picture", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.changeProfilePicture();

            Assert.assertTrue(result, "User is not able to change their profile picture");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateUserCanUpdateTheirAboutMeSection() {

        try {
            initializeTest("Profile page about me test", "This test verifies that the user can update their about me section", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.updateAboutMeSection();

            Assert.assertTrue(result, "User is not able to update their about me section");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateUserCanUpdateTheirInterestsOnProfilePage() {

        try {
            initializeTest("Profile page interests test", "This test verifies that the user can update their interests on profile page", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.updateInterests();

            Assert.assertTrue(result, "User is not able to update their interests on profile page");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void validateUserCanUpdateIndustrySettingsOnProfilePage() {

        try {
            initializeTest("Profile page industry settings test", "This test verifies that the user can update their industry settings on profile page", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.updateIndustrySettings();

            Assert.assertTrue(result, "User is not able to update their industry settings on profile page");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void validateUsersCanUpdateTheirSkillsOnProfilePage() {

        try {
            initializeTest("Profile page skills test", "This test verifies that the user can update their skills on profile page", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.updateSkills();

            Assert.assertTrue(result, "User is not able to update their skills on profile page");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void validateLanguageUpdateFunctionalityOnProfile() {

        try {
            initializeTest("Profile page Language Update test", "This test verifies that the user can update their languages on profile page", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.updateLanguages();

            Assert.assertTrue(result, "User is not able to update their languages on profile page");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test(priority = 8)
//    public void validateRateUpdateFunctionalityOnProfilePage() {
//
//        try {
//            initializeTest("Profile page Rate Update test", "This test verifies that the user can update their rate on profile page", "Sanity Test");
//
//            profilePage = PagesFactory.getProfilePage();
//
//            boolean result = profilePage.updateRate();
//
//            Assert.assertTrue(result, "User is not able to update their rate on profile page");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test(priority = 9)
    public void validateUserCanAddNewCategory() {

        try {
            initializeTest("Profile page Add Category test", "This test verifies that the user can add new category on profile page", "Sanity Test");

            profilePage = PagesFactory.getProfilePage();

            boolean result = profilePage.addNewCategory();

            Assert.assertTrue(result, "User is not able to add new category on profile page");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}