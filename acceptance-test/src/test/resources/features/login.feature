@smoke @PO18-99
Feature: ZeroBank multiple features
  Agile story: User should login with valid credentials

  Background: Login to http://zero.webappsecurity.com account with valid credentials
    Given User on start page
    When User clicks sign in button
#    User object to List<String> and @DataTableType
    When User enters valid email and password
      | email    | password |
      | username | password |
    When User go to Home page


  @test1 @PO18-98
  Scenario: Login to http://zero.webappsecurity.com account with valid credentials
    Then User should see settings icon


  @test2
  Scenario: User navigates to online banking page
    When User clicks online banking header link
      | Online Banking |
#    convert to List<String>
    Then User should see six header links on online banking page
      | Account Summary   |
      | Account Activity  |
      | Transfer Funds    |
      | Pay Bills         |
      | My Money Map      |
      | Online Statements |


  @test3
  Scenario Outline: Click <link> and verify <title>
    When User clicks online banking header link
      | Online Banking |
    When User clicks '<link>'
    When User verifies that page title is '<title>'
    Examples:
      | link              | title                    |
      | Account Summary   | Zero - Account Summary   |
      | Account Activity  | Zero - Account Activity  |
      | Transfer Funds    | Zero - Transfer Funds    |
      | Pay Bills         | Zero - Pay Bills         |
      | My Money Map      | Zero - My Money Map      |
      | Online Statements | Zero - Online Statements |

  @test4
  Scenario Outline: User logs in with valid and invalid credentials
    Examples: