#Author: mnaauval@gmail.com
Feature: Login

  @SPV
  Scenario: Login valid "SPV"
    Given User at Login Page
    When Input valid uname "EXD8200015" and valid passwd "admin12345"
    Then User click login
    And User logged in

  @SPV
  Scenario Outline: Login invalid "SPV"
    Given User at Login Page
    When Input not valid uname <uname> and not valid passwd <passwd>
    Then User click login
    And Show error

    Examples: 
      | uname      | passwd     |
      | EXD8200015 | admin54321 |
      | E8200015XD | admin12345 |
      | test       | admintest  |
      | EXD8200015 |            |
      |            | admin12345 |

  @MNGR
  Scenario: Login valid "MNGR"
    Given User at Login Page
    When Input valid uname "EXD8120011" and valid passwd "admin12345"
    Then User click login
    And User logged in

  @MNGR
  Scenario Outline: Login invalid  "MNGR"
    Given User at Login Page
    When Input not valid uname <uname> and not valid passwd <passwd>
    Then User click login
    And Show error

    Examples: 
      | uname      | passwd     |
      | EXD8120011 | admin54321 |
      | E0011XD812 | admin12345 |
      | test       | admintest  |
      | EXD8120011 |            |
      |            | admin12345 |
