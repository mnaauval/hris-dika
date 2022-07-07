#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario: Show Pengajuan Cuti from My Task
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then User at Page Pengajuan Cuti

  Scenario: Show Pengajuan Cuti from Navbar
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Pengajuan Cuti in Navbar
    Then User at Page Pengajuan Cuti
