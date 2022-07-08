#Author: mnaauval@gmail.com
Feature: Dashboard

  Scenario: Show Home Page
    Given User has logged in as MNGR
    Then User at Home Page

  Scenario: Show Signature Page
    Given User has logged in as MNGR
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    Then User at Signature Page

  Scenario: Show Approval Cuti Page from My Task
    Given User has logged in as MNGR
    And User at Home Page
    When User click Approval Cuti in My Task
    Then User at Approval Cuti Page

  Scenario: Show Approval Cuti Page from Navbar
    Given User has logged in as MNGR
    And User at Home Page
    When User click Data in Navbar
    And User click Approval Cuti in Navbar
    Then User at Approval Cuti Page
