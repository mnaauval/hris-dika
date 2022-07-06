#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario Outline: Input field notes
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created

    #And User delete data
    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes           |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Ini test notes  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 |          456546 |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | !%^&@$!!        |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | ক্ষক্ষক্ষক্ষক্ষ |
