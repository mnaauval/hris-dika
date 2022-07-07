#Author: mnaauval@gmail.com
Feature: Bucket Data Approval

  Scenario: Show Approval Cuti from My Task
    Given User has logged in as MNGR
    And User at Home Page
    When User click Approval Cuti in My Task
    Then User at Page Approval Cuti

  Scenario: Show Approval Cuti from Navbar
    Given User has logged in as MNGR
    And User at Home Page 
    When User click Data in Navbar
    And User click Approval Cuti in Navbar
    Then User at Page Approval Cuti
