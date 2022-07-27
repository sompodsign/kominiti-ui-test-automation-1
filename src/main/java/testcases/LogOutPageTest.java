package main.java.testcases;

import DataModel.TestDataModel;
import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pages.PagesFactory;


@SuppressWarnings("ThrowablePrintedToSystemOut")
public class LogOutPageTest extends BaseTest {
    @SuppressWarnings("unused")
    LoginPage loginPage;


    @Test
    public void validateJobSeekerSignUpFunctionality() {

        try {

            initializeTest("Validate signup Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();

            System.out.println("\nStarting signup into the site.\\n");
            boolean signupResult = loginPage.signupAsIndividual("job seeker");

            Assert.assertTrue(signupResult, "Signup failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    @Test
    public void validateFreelancerSignUpFunctionality() {

        try {

            initializeTest("Validate Freelancer signup Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();

            System.out.println("\nStarting signup into the site.\\n");
            boolean signupResult = loginPage.signupAsIndividual("freelancer");

            Assert.assertTrue(signupResult, "Freelancer Signup failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    @Test
    public void validateOthersSignUpFunctionality() {

        try {

            initializeTest("Validate Others signup Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();

            System.out.println("\nStarting signup into the site.\\n");
            boolean signupResult = loginPage.signupAsIndividual("others");

            Assert.assertTrue(signupResult, "Others Signup failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    @Test
    public void validateBusinessOwnerSignupFunctionality() {
        try {

            initializeTest("Validate Business Owner signup Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();

            System.out.println("\nStarting signup into the site.\\n");
            boolean signupResult = loginPage.businessSignup();

            Assert.assertTrue(signupResult, "Business Owner Signup failed");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test(dataProvider = "credentials", dataProviderClass = TestDataProvider.class,priority = 2)
    public void validateLoginFunctionality(String email, String password) {

        try {

            initializeTest("Validate Login Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();
            TestDataModel testData = new TestDataModel();

            testData.setEmail(email);
            testData.setPassword(password);


            System.out.println("\nStarting login into the site.\\n");
            boolean loginResult = loginPage.login(testData);
            Assert.assertTrue(loginResult, "Login failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    @Test
    public void validateLogoutFunctionality() {

            try {

                initializeTest("Validate Logout Functionality", "This test will verify that user is able to logout from the application", "Sanity Test");

                loginPage = PagesFactory.getLoginPage();

                System.out.println("\nStarting logout from the site.\\n");
                boolean logoutResult = loginPage.logout();

                Assert.assertTrue(logoutResult, "Logout failed");

            } catch (Exception ex) {
                System.out.println(ex);

            }
    }


}