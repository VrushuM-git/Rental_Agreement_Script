Feature: Rental Agreement Module

  @SanityTest
  Scenario: To Verify Rental Agreement Module
    Given Launch The Application
    When Hold and Handling the How It Works Pop-up
    Then Verify the Page Title
    Then Basic Details - Filling the following details
      | I_am     | FirstName | LastName  | Mobile_Number | Mail_ID                       |
      | Landlord | vrushali  | mangudkar |    7447813995 | mangudkarvrushali26@gmail.com |
    And Click on Save and Continue
    Then Popup window is appear and Enter the mobile number "7447813995"
    And Click on Send OTP
    Then Enter the OTP in Console so that user can complete authentication process
    And Click on Login
    Then save and continue
