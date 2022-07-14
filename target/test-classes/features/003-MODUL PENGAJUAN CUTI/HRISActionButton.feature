#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario Outline: Submit new valid data
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
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July20 |     2022 |   2022 | Submit new valid data |

  Scenario Outline: Submit invalid data
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
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July19 |     2022 |   2022 | Submit invalid data |

  Scenario Outline: Validate delete action
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
    And User validate data not exist

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Validate delete action |

  Scenario Outline: Cancel delete action
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And Data cuti created
    And User validate "leave" data column contain "26 Jul 2022"
    And User validate "type" data column contain "Pernikahan diri sendiri"
    Then User validate "action" data column contain "cancel"
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                  |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Cancel delete action |

  Scenario Outline: Button edit show form cuti
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
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                      |
      | Special | Pernikahan diri sendiri---(3 Hari) | July26   | July28 |     2022 |   2022 | Button edit show form cuti |

  Scenario: Select should show Annual
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July22" "2022" and input "Select should show Annual"
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
    And User edit data
    Then User validate select type "Annual"
    And User click submit
    And User delete data

  Scenario Outline: Select should show Special
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
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
    And User edit data
    Then User validate select type "Special"

    #assert false
    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July20 |     2022 |   2022 |

  Scenario: Date should show as Leave column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "August20" "2022" "August21" "2022" and input "Date should show as Leave column"
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
    And User edit data
    Then User validate date "not empty"
    And User click submit
    And User delete data

  Scenario: Notes should show as data before
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "August20" "2022" "August21" "2022" and input "Ini test notes"
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
    And User edit data
    Then User validate notes
    And User click submit
    And User delete data

  Scenario Outline: Submit valid edit data
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
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    And User click submit
    Then Data cuti created
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo | notes                    |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July21 |     2022 |   2022 | Submit invalid edit data |

  Scenario Outline: Submit invalid edit data
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "August20" "2022" "August21" "2022" and input "Submit invalid edit data"
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
    And User edit data
    And User clear field
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User click submit
    Then Data cuti not created
    And User click Pengajuan Cuti in Navbar
    And User edit data
    And User click submit
    And User delete data

    Examples: 
      | type    | special                            | dateFrom | dateTo | yearFrom | yearTo |
      | Special | Pernikahan diri sendiri---(3 Hari) | July20   | July26 |     2022 |   2022 |

  @runthis
  Scenario: Button new
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "August20" "2022" "August21" "2022" and input "Button new"
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
    And User edit data
    And User click new
    Then User validate select type "empty"
    And User validate date "empty"
    And User click Pengajuan Cuti in Navbar
    And User edit data
    And User click submit
    And User delete data
