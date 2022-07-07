#Author: mnaauval@gmail.com
Feature: Logout

  Scenario: Logout from profile "SPV"
    Given User at Login Page
    When Input valid uname "EXD8200015" and valid passwd "admin12345"
    And User click login
    And User logged in
    Then User logout from Profile
    And User logged out

  Scenario: Logout navbar "SPV"
    Given User at Login Page
    When Input valid uname "EXD8200015" and valid passwd "admin12345"
    And User click login
    And User logged in
    Then User logout from Nav
    And User logged out

  Scenario: Logout from profile "MNGR"
    Given User at Login Page
    When Input valid uname "EXD8120011" and valid passwd "admin12345"
    And User click login
    And User logged in
    Then User logout from Profile
    And User logged out

  Scenario: Logout navbar "MNGR"
    Given User at Login Page
    When Input valid uname "EXD8120011" and valid passwd "admin12345"
    And User click login
    And User logged in
    Then User logout from Nav
    And User logged out
