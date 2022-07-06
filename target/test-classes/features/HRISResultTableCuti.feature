#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario: Show total cuti
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then Show total cuti

  Scenario: Show total cuti yang bisa diambil
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then Show total cuti yang bisa diambil

  Scenario: Show total cuti bersama
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then Show total cuti bersama

  Scenario: Show total cuti approved
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then Show total cuti approved

  Scenario: Show total cuti request
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then Show total cuti request

  Scenario: Show total sisa cuti
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then Show total sisa cuti
