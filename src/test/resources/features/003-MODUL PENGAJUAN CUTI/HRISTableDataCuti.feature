#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  Scenario: Leave column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Leave column"
    And User click submit
    And Data cuti created
    Then User validate "leave" data column contain "20 Jul 2022"
    And User delete data

  Scenario: Count column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Count column"
    And User click submit
    And Data cuti created
    Then User validate "count" data column contain "6"
    And User delete data

  Scenario: Type column
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Type column"
    And User click submit
    And Data cuti created
    Then User validate "type" data column contain "Annual"
    And User delete data

  Scenario: Status column init
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Status column init"
    And User click submit
    And Data cuti created
    Then User validate "status" data column contain "Queue"
    And User delete data

  Scenario: Status column returned
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Status column returned"
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
    And User click submit
    And User delete data

  Scenario: Status column rejected
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Status column rejected"
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

  Scenario: Status column approved
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Status column approved"
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

  Scenario: Action column init
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Action column init"
    And User click submit
    And Data cuti created
    Then User validate "action" data column contain "cancel"
    And User delete data

  Scenario: Action column returned
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Action column returned"
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
    And User click submit
    And User delete data

  Scenario: Action column rejected
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Action column rejected"
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
    
  Scenario: Action column approved
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July26" "2022" and input "Action column approved"
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

  @runthis
  Scenario: Empty table
    Given User has logged in as SPV
    When User at Home Page
    And User click Pengajuan Cuti in My Task
    Then User validate data not exist