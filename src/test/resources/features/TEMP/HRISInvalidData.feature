#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario Outline: Empty type
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    Then User click submit
    And Show error type field

  Scenario Outline: Empty date
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    Then User click submit
    And Show error date field

  Scenario Outline: Empty all field
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    Then User click submit
    And Show error type field
    And Show error date field
    And Show error note field
