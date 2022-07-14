#Author: mnaauval@gmail.com
Feature: Bucket Data Approval

  Scenario Outline: Action return validate with notes
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    And User input approval notes <notes>
    Then User validate approval notes "return" button
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    Then User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                             |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action return validate with notes |

  Scenario Outline: Action return validate no notes
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    And User input approval notes <notes>
    Then User validate approval notes "return" button
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    Then User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 |       |

  Scenario Outline: Action return cancel with notes
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    And User input approval notes <notes>
    And User "cancel" "return" cuti
    Then User validate modal action "return"
    And User close modal with "close"
    And User edit data
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                           |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action return cancel with notes |

  @runthis
  Scenario Outline: Action return cancel no notes
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    And User "cancel" "return" cuti
    Then User validate modal action "return"
    And User close modal with "close"
    And User edit data
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 |       |
