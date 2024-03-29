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
    And Validate alert
    And Data cuti created

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes          |
      | Special | Pernikahan diri sendiri---(3 Hari) | July9    | July10 |     2022 |   2022 | From < current |

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
      | Special | Pernikahan diri sendiri---(3 Hari) | July14   | July15 |     2022 |   2022 | From = current |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July21 |     2022 |   2022 | From > current |

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
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes     |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July19 |     2022 |   2022 | To < From |

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
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes     |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July20 |     2022 |   2022 | To = From |

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
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes     |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July22 |     2022 |   2022 | To > From |

  Scenario Outline: Empty date
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    Then User click submit
    And Show error date field
