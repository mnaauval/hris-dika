#Author: mnaauval@gmail.com
Feature: Login

  Scenario: Login valid "SPV"
    Given User at Login Page
    When Input valid uname "EXD8200015" and valid passwd "admin12345"
    Then User click login
    And User logged in
    
  Scenario: Login valid "MNGR"
    Given User at Login Page
    When Input valid uname "EXD8120011" and valid passwd "admin12345"
    Then User click login
    And User logged in

  Scenario Outline: Login not valid
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
