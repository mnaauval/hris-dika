#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario Outline: Leave column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    Then User validate "leave" data column contain "26 Jul 2022"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes        |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Leave column |

  Scenario Outline: Count column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    Then User validate "count" data column contain "3"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes        |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Count column |

  Scenario Outline: Type column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    Then User validate "type" data column contain "Pernikahan diri sendiri"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes       |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Type column |

  Scenario Outline: Status column init
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    Then User validate "status" data column contain "Queue"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes              |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Status column init |

  Scenario Outline: Status column returned
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
    And User "validate" "return" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate "status" data column contain "Queue"
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Status column returned |
@runthis
  Scenario Outline: Status column rejected
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
    And User "validate" "reject" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate data not exist

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Status column rejected |

  Scenario Outline: Status column approved
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
    And User "validate" "approve" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate "status" data column contain "Approve"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Status column approved |

  Scenario Outline: Action column init
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    Then User validate "action" data column contain "cancel"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes              |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Action column init |

  Scenario Outline: Action column returned
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
    And User "validate" "return" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate "action" data column contain "edit"
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Action column returned |

  Scenario Outline: Action column rejected
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
    And User "validate" "reject" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User validate data not exist

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Action column rejected |

  Scenario Outline: Action column approved
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
    And User "validate" "approve" cuti
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate "action" data column contain "cancel"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Action column approved |

  @runthis
  Scenario: Empty table
    Given User has logged in as SPV
    When User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate data not exist
