package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import actions.UserManagementActions;
import utils.Selenium;

import java.util.Map;

public class UserManagementSteps {

    UserManagementActions userManagementActions = new UserManagementActions();


    @Given("User goes to {string}")
    public void user_goes_to(String webPageName) {
        userManagementActions.goToPage(webPageName);
        Selenium.waitForPageToLoad();
    }

    @When("User click {string}")
    public void userClick(String button) {
        userManagementActions.clickBtn(button);
    }

    @When("enter following in the new link inputs:")
    public void enterFollowingInTheNewLinkInputs(Map<String, String> dataTable) {
        userManagementActions.createNewUser(dataTable);
    }

    @And("user selects role {string}")
    public void userSelectsRole(String role) {
        userManagementActions.userSelect(role);
    }

    @Then("verify user exist in the table")
    public void verifyUserExistInTheTable(Map<String, String> user) {
        Assert.assertTrue(userManagementActions.isUserPresent(user), "User was not found");
    }

    @And("user choose company name")
    public void userChooseCompanyName(Map<String, String> companyName) {
        userManagementActions.selectCustomerType(companyName);
    }

    @And("user provides following data")
    public void userProvidesFollowingData(Map<String, String> newUserCredentials) {
        userManagementActions.createNewUser(newUserCredentials);
    }

    @And("delete user")
    public void deleteUser(Map<String, String> user) {
        userManagementActions.deleteUser(user);
    }

    @And("confirm user deletion")
    public void confirmUserDeletion() {
       userManagementActions.userDeletionConfirmation();
    }

    @And("verify user does not exist in the table")
    public void verifyUserDoesNotExistInTheTable(Map<String, String> user) {
        Assert.assertFalse(userManagementActions.isUserPresent(user), "User does not exist");
    }
}
