#Author: mnaauval@gmail.com
Feature: Bucket Data Approval

  Scenario Outline: Tanggal cuti in approval
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
    Then User validate modal "tanggal"
    And User "validate" "reject" cuti

    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes                    |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Tanggal cuti in approval |

  Scenario: Close modal with close
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "November9" "2022" "November10" "2022" and input "Close modal with close"
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    Then User close modal with "leave modal"
    And User edit data
    And User "validate" "reject" cuti

  Scenario: Close modal with cross
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "November9" "2022" "November10" "2022" and input "Close modal with cross"
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    Then User close modal with "leave modal"
    And User edit data
    And User "validate" "reject" cuti

  Scenario: Close modal with leave modal
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "November9" "2022" "November10" "2022" and input "Close modal with leave modal"
    And User click submit
    And Data cuti created
    And User logout from Nav
    And User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    And User edit data
    Then User close modal with "leave modal"
    And User edit data
    And User "validate" "reject" cuti
