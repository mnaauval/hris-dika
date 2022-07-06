#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario: Draw and save
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    And User draw signature
    Then User save signature
    And User validate signture
