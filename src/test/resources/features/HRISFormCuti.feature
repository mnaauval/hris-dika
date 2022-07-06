#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  @notes
  Scenario Outline: Input field notes
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created

    #And User delete data
    Examples: 
      | type    | special                            | dateFrom | dateTo   | yearFrom | yearTo | notes           |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | Ini test notes  |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 |          456546 |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | !%^&@$!!        |
      | Special | Pernikahan diri sendiri---(3 Hari) | August20 | August22 |     2022 |   2022 | ক্ষক্ষক্ষক্ষক্ষ |

  @search
  Scenario Outline: Cuti type Annual and count date "LESS" than 12
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input notes
    Then User click submit
    And Data cuti created

  @search @entries
  Scenario Outline: Cuti type Special and count date "LESS" than max count
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created

    #And User delete data
    Examples: 
      | type    | special                                                     | dateFrom | dateTo    | yearFrom | yearTo | notes    |
      | Special | Persalinan/Keguguran istri---(2 Hari)                       | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan diri sendiri---(3 Hari)                          | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                  | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                  | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                  | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                  | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                  | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Khitanan/Pembabtisan anak---(2 Hari)                        | July21   | July22    |     2022 |   2022 | Ini test |
      | Special | Cuti persalinan---(3 Bulan)                                 | July20   | November1 |     2022 |   2022 | Ini test |
      | Special | Cuti duka (orang tua, anak, suami/istri, mertua)---(2 Hari) | July20   | July20    |     2022 |   2022 | Ini test |

  @search @onlysearch
  Scenario Outline: Search by value
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User search by value <value>
    Then User validate search <value>

    #And User delete data
    Examples: 
      | value      |
      | November   |
      |         90 |
      | Annual     |
      | Khitanan   |
      | Incomplete |
      |            |

  @search @onlyentries
  Scenario Outline: Search by value
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User choose show <entries> entries
    Then User validate show <entries>

    #And User delete data
    Examples: 
      | entries |
      |      10 |
      |      25 |
