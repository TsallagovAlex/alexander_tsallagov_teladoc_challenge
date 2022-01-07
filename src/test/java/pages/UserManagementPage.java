package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagementPage {
    public UserManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public Map<Integer,String> tableHeadIndexes(){
        Map<Integer,String> indexesMapHeaders = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            indexesMapHeaders.put(i,columnNames.get(i).getText());
        }
        return indexesMapHeaders;
    }

    @FindBy(className = "header-content")
    public List<WebElement> columnNames;

    @FindBy(className = "btn")
    public WebElement addUser;

    @FindBy(name = "FirstName")
    public WebElement firstName;

    @FindBy(name = "LastName")
    public WebElement lastName;

    @FindBy(name = "UserName")
    public WebElement userName;

    @FindBy(name = "Password")
    public WebElement password;

    @FindBy(className = "radio")
    public List<WebElement> customer;

    @FindBy(name = "RoleId")
    public WebElement selectRole;

    @FindBy(name = "Email")
    public WebElement email;

    @FindBy(name = "Mobilephone")
    public WebElement mobilephone;

    @FindBy(className ="btn-success")
    public WebElement saveButton;

    @FindBy(className = "smart-table-data-row")
    public List<WebElement> listOfUsers;

    @FindBy(className = "icon-remove")
    public List<WebElement> deleteUserBtn;

    @FindBy(className = "btn-primary")
    public WebElement userDeletionConfirmationButton;

}
