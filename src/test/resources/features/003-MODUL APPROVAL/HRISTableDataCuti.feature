#Author: mnaauval@gmail.com
Feature: Bucket Data Approval

  Scenario Outline: Leave column (name)
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
    Then User validate approval "leave name" data column contain "ADHITYA BAYU"
    And User edit data
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes               |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Leave column (name) |

  Scenario Outline: Leave column (date)
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
    Then User validate approval "leave date" data column contain "20 Aug 2022"
    And User edit data
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes               |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Leave column (date) |

  Scenario Outline: Count column
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
    Then User validate approval "count" data column contain "3"
    And User edit data
    And User "validate" "reject" cuti
    #senin libur
    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes        |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August23 |     2022 |   2022 | Count column |

  Scenario Outline: Type column
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
    Then User validate approval "leave type" data column contain "Pernikahan diri sendiri"
    And User edit data
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes        |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Count column |

  Scenario Outline: Status new column
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
    Then User validate approval "status" data column contain "Queue"
    And User edit data
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes             |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Status new column |

  Scenario Outline: Status returned column
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
    Then User validate approval "missing data" data column contain "20 Aug 2022"
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Status returned column |

  Scenario Outline: Status rejected column
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
    Then User validate approval "missing data" data column contain "20 Jul 2022"

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Status rejected column |

  Scenario Outline: Status approved column
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
    Then User validate approval "status" data column contain "Approve"
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Status approved column |

  Scenario Outline: Action new column
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
    Then User validate approval "action" data column contain "edit"
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes             |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action new column |

  Scenario Outline: Action returned column
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
    Then User validate approval "action" data column contain "none"
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action returned column |

  Scenario Outline: Action rejected column
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
    Then User validate approval "action" data column contain "none"

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action rejected column |

  Scenario Outline: Action approved column
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
    Then User validate approval "action" data column contain "none"
    And User logout from Nav
    And User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action approved column |

  Scenario Outline: Action edit pressed
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
    Then User validate modal "present"
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes               |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Action edit pressed |
