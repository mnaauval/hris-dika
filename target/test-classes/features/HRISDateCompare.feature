#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  @datecompare @comparecurrent
  Scenario Outline: Compare date "From with current"
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created
    And Check action

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes          |
      | Special | Pernikahan diri sendiri---(3 Hari) | July5    | July6  |     2022 |   2022 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari) | July6    | July7  |     2022 |   2022 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari) | July7    | July8  |     2022 |   2022 | Ini test notes |

  @datecompare
  Scenario Outline: Compare date "To < From"
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Database occured

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes          |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July19 |     2022 |   2022 | Ini test notes |

  @datecompare
  Scenario Outline: Compare date "To = From"
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
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes          |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July20 |     2022 |   2022 | Ini test notes |

  @datecompare
  Scenario Outline: Compare date "To > From"
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
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes          |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July22 |     2022 |   2022 | Ini test notes |
