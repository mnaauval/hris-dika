#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  @datasample
  Scenario: Cuti type Annual
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input "Cuti type Annual"
    Then User click submit
    And Data cuti created

  @datasample
  Scenario Outline: Cuti type Special
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created

    Examples: 
      | type    | special                                                               | dateFrom | dateTo    | yearFrom | yearTo | notes    |
      | Special | Persalinan/Keguguran istri---(2 Hari)                                 | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan diri sendiri---(3 Hari)                                    | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July20    |     2022 |   2022 | Ini test |
      | Special | Khitanan/Pembabtisan anak---(2 Hari)                                  | July21   | July22    |     2022 |   2022 | Ini test |
      | Special | Cuti persalinan---(3 Bulan)                                           | July20   | November1 |     2022 |   2022 | Ini test |
      | Special | Cuti persalinan---(3 Bulan)                                           | July20   | November1 |     2022 |   2022 | Ini test |
      | Special | Cuti duka saudara kandung/keluarga yang tinggal satu rumah---(1 Hari) | July20   | July20    |     2022 |   2022 | Ini test |
@runthis
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
      | persalinan |
      | Incomplete |
      #| Queue    |
      |            |
@runthis
  Scenario Outline: Entries
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User choose show <entries> entries
    Then User validate show entries <entries>

    #And User delete data
    Examples: 
      | entries |
      |      10 |
      |      25 |
