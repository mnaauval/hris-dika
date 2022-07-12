#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario: Cuti type Annual not approved yet
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Cuti type Annual not approved yet"
    And User click submit
    And Data cuti created
    And User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Cuti type Annual not approved yet"
    Then User click submit
    And Data cuti not created
    And User delete data

  Scenario: Cuti type Annual approved
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Cuti type Annual approved"
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
    And User click button form cuti
    And User select type "Annual", pick range date "July27" "2022" "August2" "2022" and input "Cuti type Annual approved"
    Then User click submit
    And Data cuti created
    And User delete data
    And User delete data

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

  @runthis
  Scenario Outline: Cuti type Special approved
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
    Then User click Pengajuan Cuti in My Task
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
