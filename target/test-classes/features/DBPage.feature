@TeladocChallenge
Feature: teladocChallenge

  @TeladocScenarioOne
  Scenario: Add a user and validate the user has been added to the table
#    Given User goes to "user management page"
    When User click "add user button"
    And user provides following data
      | First Name   | Alexander      |
      | Last Name    | Tsallagov      |
      | User Name    | TsallagTest    |
      | Password     | qsxwdc1234!@#$ |
      | Email        | test@gmail.com |
      | Phone Number | 1234567890     |
    And user choose company name
      | Company Name | Company BBB |
    And user selects role "Admin"
    And User click "save button"
    Then verify user exist in the table
      | First Name | Alexander   |
      | Last Name  | Tsallagov   |
      | User Name  | TsallagTest |

  @TeladocScenarioTwo
  Scenario: Delete user User Name: novak and validate user has been delete
   Given User goes to "user management page"
    Then verify user exist in the table
      | First Name | Mark  |
      | Last Name  | Novak |
      | User Name  | novak |
    And delete user
      | First Name | Mark  |
      | Last Name  | Novak |
      | User Name  | novak |
    And confirm user deletion
    And verify user does not exist in the table
      | First Name | Mark  |
      | Last Name  | Novak |
      | User Name  | novak |


  Scenario: Delete user User Name: Alex and validate user has been delete
    Given User goes to "user management page"
    Then verify user exist in the table
      | First Name   | testadmin      |
      | Last Name    | testadmin      |
      | User Name    | testadmin    |
    And delete user
      | First Name   | testadmin      |
      | Last Name    | testadmin      |
      | User Name    | testadmin    |
    And verify user exist in the table
      | First Name   | testadmin      |
      | Last Name    | testadmin      |
      | User Name    | testadmin    |

