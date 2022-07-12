#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario: Button form cuti show form cuti
    Given User has logged in as SPV
    And User at Home Page
    When User click Pengajuan Cuti in My Task
    Then User click button form cuti

  Scenario: Cuti type Annual
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input "Cuti type Annual"
    Then User click submit
    And Data cuti created
    And User delete data

  Scenario Outline: Cuti type Special
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created
    And User delete data

    Examples: 
      | type    | special                                                               | dateFrom | dateTo  | yearFrom | yearTo | notes          |
      | Special | Persalinan/Keguguran istri---(2 Hari)                                 | July20   | July20  |     2022 |   2022 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari)                                    | July20   | July20  |     2022 |   2022 | Ini test notes |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July20  |     2022 |   2022 | Ini test notes |
      | Special | Khitanan/Pembabtisan anak---(2 Hari)                                  | July20   | July20  |     2022 |   2022 | Ini test notes |
      | Special | Cuti persalinan---(3 Bulan)                                           | July20   | August1 |     2022 |   2022 | Ini test notes |
      | Special | Cuti duka (orang tua, anak, suami/istri, mertua)---(2 Hari)           | July20   | July20  |     2022 |   2022 | Ini test notes |
      | Special | Cuti duka saudara kandung/keluarga yang tinggal satu rumah---(1 Hari) | July20   | July20  |     2022 |   2022 | Ini test notes |

  Scenario Outline: Empty type
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    Then User click submit
    And Show error type field

  @runthis
  Scenario Outline: Empty special
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Special"
    Then User click submit
    And User select type "Special"
    And Show error special field
