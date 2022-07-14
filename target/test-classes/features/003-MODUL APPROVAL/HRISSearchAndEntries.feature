#Author: mnaauval@gmail.com
Feature: Bucket Data Approval

  Scenario Outline: Search by value
    Given User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    When User search by value <value>
    Then User validate search <value>

    #And User delete data
    Examples: 
      | value      |
      | November   |
      |         90 |
      | Pernikahan |
      | persalinan |
      | Incomplete |
      #| Queue    |
      |            |

  Scenario Outline: Entries
    Given User has logged in as MNGR
    And User at Home Page
    And User click Approval Cuti in My Task
    And User at Approval Cuti Page
    When User choose show <entries> entries
    Then User validate show entries <entries>

    #And User delete data
    Examples: 
      | entries |
      |      10 |
      |      25 |
