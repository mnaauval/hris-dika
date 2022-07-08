#Author: mnaauval@gmail.com
Feature: Dashboard

  Scenario: Show Home Page
    Given User has logged in as SPV
    Then User at Home Page

  Scenario: Show Pengajuan Cuti Page from My Task
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then User at Pengajuan Cuti Page

  Scenario: Show Pengajuan Cuti Page from Navbar
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Pengajuan Cuti in Navbar
    Then User at Pengajuan Cuti Page

  Scenario: Show Signature Page
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    Then User at Signature Page
