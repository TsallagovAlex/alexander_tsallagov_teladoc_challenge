package actions;

import pages.UserManagementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Cucumber;
import utils.Driver;
import utils.Selenium;

import java.util.List;
import java.util.Map;

public class UserManagementActions {
    UserManagementPage userManagementPage = new UserManagementPage();

    public void goToPage(String webPageName) {
        switch (webPageName) {
            case "user management page":
                Driver.getDriver().get(ConfigReader.readProperty("url", "src/test/resources/config/configuration.properties"));
                Cucumber.logInfo("open" + webPageName, true);
                break;
            default:
                System.out.println("Wrong name of the link was parsed");
        }
    }

    public void createNewUser(Map<String, String> dataTable) {
        for (String key : dataTable.keySet())
            switch (key) {
                case "First Name":
                    Selenium.sendKeys(userManagementPage.firstName, dataTable.get(key));
                    break;
                case "Last Name":
                    Selenium.sendKeys(userManagementPage.lastName, dataTable.get(key));
                    break;
                case "User Name":
                    Selenium.sendKeys(userManagementPage.userName, dataTable.get(key));
                    break;
                case "Password":
                    Selenium.sendKeys(userManagementPage.password, dataTable.get(key));
                    break;
                case "Email":
                    Selenium.sendKeys(userManagementPage.email, dataTable.get(key));
                    break;
                case "Phone Number":
                    Selenium.sendKeys(userManagementPage.mobilephone, dataTable.get(key));
                    break;
            }
    }

    public void selectCustomerType(Map<String, String> dataTable) {
        for (String key : dataTable.keySet())
            for (int i = 0; i < userManagementPage.customer.size(); i++) {
                if (!userManagementPage.customer.get(i).getText().equals(dataTable.get(key))) {
                    continue;
                } else
                Assert.assertTrue(userManagementPage.customer.get(i).getText().equals(dataTable.get(key)));
                Selenium.click(userManagementPage.customer.get(i));

            }
    }

    public void clickBtn(String btnName) {
        switch (btnName.toLowerCase()) {
            case "add user button":
                Selenium.waitForClickability(userManagementPage.addUser);
                Selenium.click(userManagementPage.addUser);
                break;
            case "save button":
                Selenium.waitForClickability(userManagementPage.saveButton);
                Selenium.click(userManagementPage.saveButton);
                break;
            case "delete user button":
                for (int i = 0; i > userManagementPage.listOfUsers.size(); i++) {
                    Selenium.waitForClickability(userManagementPage.deleteUserBtn.get(i));
                    Selenium.click(userManagementPage.deleteUserBtn.get(i));
                }
                break;
            default:
                System.out.println("Wrong button name provided. Please make sure to provide correct button name");


        }
    }

    public void userSelect(String role) {
        Selenium.highlightElement(userManagementPage.selectRole);
        Select adminRole = new Select(userManagementPage.selectRole);
        adminRole.selectByVisibleText(role);

    }

    public boolean isUserPresent(Map<String, String> dataTable) {
        rows:
        for (int i = 0; i < userManagementPage.listOfUsers.size(); i++) {
            List<WebElement> columns = userManagementPage.listOfUsers.get(i).findElements(By.className("smart-table-data-cell"));
            for (int j = 0; j < columns.size(); j++) {
                String currentColumn = userManagementPage.tableHeadIndexes().get(j);
                String expected = dataTable.get(currentColumn);
                String actual = columns.get(j).getText();
                if (!expected.contains(actual)) {
                    continue rows;
                }
                boolean fullMatch = columns.get(dataTable.size() - 1).getText().equals(expected);
                if (fullMatch) return true;
            }
        }
        return false;
    }

    public void deleteUser(Map<String, String> dataTable) {
        rows:
        for (int i = 0; i < userManagementPage.listOfUsers.size(); i++) {
            List<WebElement> columns = userManagementPage.listOfUsers.get(i).findElements(By.className("smart-table-data-cell"));
            for (int j = 0; j < columns.size(); j++) {
                String currentColumn = userManagementPage.tableHeadIndexes().get(j);
                String expected = dataTable.get(currentColumn);
                String actual = columns.get(j).getText();
                if (!expected.contains(actual)) {
                    continue rows;
                }
                boolean fullMatch = columns.get(dataTable.size() - 1).getText().equals(expected);
                if (fullMatch) {
                    Selenium.click(userManagementPage.deleteUserBtn.get(i));
                    return;
                }
            }
        }
        throw new RuntimeException("User was not found");
    }
    public void userDeletionConfirmation(){
          Selenium.click(userManagementPage.userDeletionConfirmationButton);
    }
}

