#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  @tagannual
  Scenario Outline: Cuti type Annual and count date "LESS" than 12
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "July27" "2022" and input "Cuti type Annual and count date less than 12"
    Then User click submit
    And Data cuti created
    And Count less than <count>
    And User delete data

    Examples: 
      | count |
      |    12 |

  @tagannual
  Scenario Outline: Cuti type Annual and count date "EQUALS" 12
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "August2" "2022" and input "Cuti type Annual and count date equals 12"
    Then User click submit
    And Data cuti created
    And Count equals <count>
    And User delete data

    Examples: 
      | count |
      |    12 |

  @tagannual @invalid
  Scenario: Cuti type Annual and count date "MORE" than 12
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type "Annual", pick range date "July20" "2022" "August3" "2022" and input "Cuti type Annual and count date more than 12"
    Then User click submit
    And Data cuti not created

  @tagspecial
  Scenario Outline: Cuti type Special and count date "LESS" than max count
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created
    And Count less than <count>

    #And User delete data
    Examples: 
      | type    | special                                                     | dateFrom | dateTo  | yearFrom | yearTo | count | notes          |
      | Special | Persalinan/Keguguran istri---(2 Hari)                       | July20   | July20  |     2022 |   2022 |     2 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari)                          | July20   | July20  |     2022 |   2022 |     3 | Ini test notes |
      | Special | Pernikahan anak---(2 Hari)                                  | July20   | July20  |     2022 |   2022 |     2 | Ini test notes |
      | Special | Khitanan/Pembabtisan anak---(2 Hari)                        | July20   | July20  |     2022 |   2022 |     2 | Ini test notes |
      | Special | Cuti persalinan---(3 Bulan)                                 | July20   | August1 |     2022 |   2022 |    90 | Ini test notes |
      | Special | Cuti duka (orang tua, anak, suami/istri, mertua)---(2 Hari) | July20   | July20  |     2022 |   2022 |     2 | Ini test notes |

  @tagspecial
  Scenario Outline: Cuti type Special and count date "EQUALS" max count
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created
    And Count equals <count>

    #And User delete data
    Examples: 
      | type    | special                                                               | dateFrom | dateTo    | yearFrom | yearTo | count | notes          |
      | Special | Persalinan/Keguguran istri---(2 Hari)                                 | July20   | July21    |     2022 |   2022 |     2 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari)                                    | July20   | July22    |     2022 |   2022 |     3 | Ini test notes |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July21    |     2022 |   2022 |     2 | Ini test notes |
      | Special | Khitanan/Pembabtisan anak---(2 Hari)                                  | July20   | July21    |     2022 |   2022 |     2 | Ini test notes |
      | Special | Cuti persalinan---(3 Bulan)                                           | July20   | November1 |     2022 |   2022 |    90 | Ini test notes |
      | Special | Cuti duka (orang tua, anak, suami/istri, mertua)---(2 Hari)           | July20   | July21    |     2022 |   2022 |     2 | Ini test notes |
      | Special | Cuti duka saudara kandung/keluarga yang tinggal satu rumah---(1 Hari) | July20   | July20    |     2022 |   2022 |     1 | Ini test notes |

  @tagspecial @invalid
  Scenario Outline: Cuti type Special and count date "MORE" than max count
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti not created

    Examples: 
      | type    | special                                                               | dateFrom | dateTo    | yearFrom | yearTo | notes          |
      | Special | Persalinan/Keguguran istri---(2 Hari)                                 | July20   | July22    |     2022 |   2022 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari)                                    | July20   | July23    |     2022 |   2022 | Ini test notes |
      | Special | Pernikahan anak---(2 Hari)                                            | July20   | July22    |     2022 |   2022 | Ini test notes |
      | Special | Khitanan/Pembabtisan anak---(2 Hari)                                  | July20   | July22    |     2022 |   2022 | Ini test notes |
      | Special | Cuti persalinan---(3 Bulan)                                           | July20   | November2 |     2022 |   2022 | Ini test notes |
      | Special | Cuti duka (orang tua, anak, suami/istri, mertua)---(2 Hari)           | July20   | July22    |     2022 |   2022 | Ini test notes |
      | Special | Cuti duka saudara kandung/keluarga yang tinggal satu rumah---(1 Hari) | July20   | July21    |     2022 |   2022 | Ini test notes |

  @countdate
  Scenario Outline: Count date as expected
    Given User has logged in as SPV
    And User at Home Page
    And User click Pengajuan Cuti in My Task
    When User click button form cuti
    And User select type <type>, select special <special>, pick range date <dateFrom> <yearFrom> <dateTo> <yearTo>
    And User input notes <notes>
    Then User click submit
    And Data cuti created
    And Count equals <count>
    And User delete data

    Examples: 
      | type    | special                              | dateFrom | dateTo | yearFrom | yearTo | count | notes          |
      | Special | Cuti persalinan---(3 Bulan)          | July25   | July27 |     2022 |   2022 |     3 | Ini test notes |
      | Special | Pernikahan diri sendiri---(3 Hari)   | July21   | July22 |     2022 |   2022 |     2 | Ini test notes |
      | Special | Khitanan/Pembabtisan anak---(2 Hari) | July23   | July24 |     2022 |   2022 |     0 | Ini test notes |
