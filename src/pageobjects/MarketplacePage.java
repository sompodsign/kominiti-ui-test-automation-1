package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PagesFactory;


public class MarketplacePage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: marketplace page elements
    @FindBy(xpath = "//a[contains(text(),'Marketplace')]")
    WebElement dashboardLink;

    @FindBy(xpath = "//h1[normalize-space()='WELCOME TO THE KOMINITI MARKETPLACE']")
    WebElement marketplacePageHeader;

    @FindBy(xpath = "//input[@placeholder='search for projects']")
    WebElement searchField;

    @FindBy(xpath = "//input[@placeholder='Category']")
    WebElement categoryField;

    @FindBy(xpath = "//input[@placeholder='Category']/parent::div/parent::div/following-sibling::div//li")
    WebElement categoryList;

    @FindBy(xpath = "//li[normalize-space()='Web, Mobile & Software Dev']")
    WebElement categoryWebMobileSoftwareDev;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(@value,'1 Projects found')]")
    WebElement projectSearchResult;

    @FindBy(xpath = "//button[normalize-space()='View all categories']")
    WebElement viewAllCategoriesButton;

    @FindBy(xpath = "(//*[contains(text(),'Accounting & Finance')])[3]")
    WebElement accountingFinanceHeader;

    @FindBy(xpath = "//h3[.='Categories']/parent::div/child::div/child::div/child::div")
    WebElement categoriesList;

    @FindBy(xpath = "//button[normalize-space()='Create Project']")
    WebElement createProjectButton;

    @FindBy(xpath = "//textarea[@placeholder='I need someone to help me with my project.']")
    WebElement projectTitleField;

    @FindBy(xpath = "//span[normalize-space()='Select project category']/parent::div/child::div//input")
    WebElement projectCategoryField;

    @FindBy(xpath = "//span[normalize-space()='Select project category']/parent::div//li")
    WebElement projectCategoryList;

    @FindBy(xpath = "//span[normalize-space()='Select project sub-category']/parent::div//input")
    WebElement projectSubCategoryField;

    @FindBy(xpath = "//span[normalize-space()='Select project sub-category']/parent::div//li")
    WebElement projectSubCategoryList;

    @FindBy(xpath = "//*[contains(text(), 'Keywords')]/parent::div//input")
    WebElement keywordsField;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Save & Continue']")
    WebElement saveAndContinueButton;

    @FindBy(xpath = "(//h3[contains(text(),'Description & FAQ')])[2]")
    WebElement descriptionAndFaqHeader;

    @FindBy(xpath = "//textarea[@name='details']")
    WebElement projectDescriptionField;

    @FindBy(xpath = "//*[contains(text(), \"Project type\")]/parent::div//input")
    WebElement projectTypeField;

    @FindBy(xpath = "//span[normalize-space()='Who can bid on this project']/parent::div//input")
    WebElement whoCanBidField;

    @FindBy(xpath = "//span[normalize-space()='Project type']/parent::div/child::div//li")
    WebElement projectTypeList;

    @FindBy(xpath = "//span[normalize-space()='Who can bid on this project']/parent::div/child::div//li")
    WebElement whoCanBidList;

    @FindBy(xpath = "//button[normalize-space()='Add Question']")
    WebElement addQuestionButton;

    @FindBy(xpath = "//textarea[@name='qamodalquestion']")
    WebElement questionField;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton;

    @FindBy(xpath = "(//h3[contains(text(),'Pricing')])[2]")
    WebElement pricingHeader;

    @FindBy(xpath = "//div[@class='base-border-block--head']//h3[contains(text(),'Requirements')]")
    WebElement requirementsHeader;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    WebElement deadlineDateField;

    @FindBy(xpath = "//span[normalize-space()='Expected project duration']/parent::div//input")
    WebElement expectedProjectDurationField;

    @FindBy(xpath = "//span[normalize-space()='Expected project duration']/parent::div//li")
    WebElement expectedProjectDurationList;

    @FindBy(xpath = "//span[normalize-space()='Expected experience level']/parent::div//input")
    WebElement expectedExperienceLevelField;

    @FindBy(xpath = "//span[normalize-space()='Expected experience level']/parent::div//li")
    WebElement expectedExperienceLevelList;

    @FindBy(xpath = "//span[normalize-space()='Required skills']/parent::div//input")
    WebElement requiredSkillsField;

    @FindBy(xpath = "//span[normalize-space()='Required skills']/parent::div//li")
    WebElement requiredSkillsList;

    @FindBy(xpath = "(//h3[contains(text(),'Gallery')])[2]")
    WebElement galleryHeader;

    @FindBy(xpath = "//input[@accept='image/*']")
    WebElement galleryImageField;

    @FindBy(xpath = "(//input)[4]")
    WebElement imageUploadField;

    @FindBy(xpath = "//h3[normalize-space()='Preview']")
    WebElement previewHeader;

    @FindBy(xpath = "//p[contains(text(),'Your project,')]")
    WebElement projectSubmissionModal;





    // END: marketplace page elements


    public MarketplacePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkMarketplacePageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(dashboardLink);
            step++;
            System.out.println("Step " + step + ": Click on Marketplace link");

            return driverWaits.waitUntilVisible(20, marketplacePageHeader);

        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkProjectSearchResult() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(searchField);
            step++;
            System.out.println("Step " + step + ": Click on search field");

            driverActions.typeText(searchField, "Tester");
            step++;
            System.out.println("Step " + step + ": Type 'SQA' in search field");

            driverActions.clickOnWebElementWithActionsClass(categoryField);
            driverActions.clickOnWebElementWithActionsClass(categoryWebMobileSoftwareDev);
            step++;
            System.out.println("Step " + step + ": Click on category field and select 'Web, Mobile & Software Dev'");

            driverActions.clickOnWebElementWithActionsClass(searchButton);
            step++;
            System.out.println("Step " + step + ": Click on search button");

            boolean result = driverWaits.waitUntilVisible(20, projectSearchResult);
            step++;
            System.out.println("Step " + step + ": Wait until project search result is visible");

            driverActions.browserBack();
            step++;
            System.out.println("Step " + step + ": Browser back");

            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkViewAllCategoriesButtonFunctionality() {
        try {
            int step = 0;

            driverWaits.waitThreeSeconds();
            driverActions.clickOnWebElementWithActionsClass(viewAllCategoriesButton);
            step++;
            System.out.println("Step " + step + ": Click on View all categories button");

            boolean result = driver.getCurrentUrl().contains("/categories");
            step++;
            System.out.println("Step " + step + ": Wait until category list is visible");

            driverActions.browserBack();
            step++;
            System.out.println("Step " + step + ": Browser back");

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}