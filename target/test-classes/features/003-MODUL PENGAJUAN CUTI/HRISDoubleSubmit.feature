#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  @doublesubmit
  Scenario: Cuti type Annual not approved yet
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input notes
    And User click submit
    And Data cuti created
    And User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input notes
    Then User click submit
    And Data cuti not created
    And User delete data

  @doublesubmit
  Scenario Outline: Cuti type Special not approved yet
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    And User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created
    And User delete data
    And User delete data

    Examples: 
      | type    | special                     | dateFrom | dateTo | yearFrom | yearTo | notes          |
      | Special | Cuti persalinan---(3 Bulan) | July20   | July20 |     2022 |   2022 | Ini test notes |