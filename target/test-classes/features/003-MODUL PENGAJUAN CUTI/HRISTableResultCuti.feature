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

  Scenario: Show total cuti approved
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input "Show total cuti approved"
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    And User "validate" "approve" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    Then User click Pengajuan Cuti in My Task
    And Show total cuti approved changed
    And User delete data

  Scenario: Show total cuti request
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input "Show total cuti request"
    And User click submit
    And Data cuti created
    And Show total cuti request changed
    And User delete data

	@runthis
  Scenario: Show total sisa cuti
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input "Show total sisa cuti"
    And User click submit
    And Data cuti created
    And Show Show total sisa cuti changed
    And User delete data
