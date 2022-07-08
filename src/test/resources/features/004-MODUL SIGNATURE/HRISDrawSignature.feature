#Author: mnaauval@gmail.com
Feature: Bucket Data Pengajuan

  @spv
  Scenario: Draw and save
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    And User draw signature
    Then User save signature
    And User validate signature

  @spv
  Scenario: Empty canvas and save
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    Then User save signature
    And User validate signature

  @emptycanvas @spv
  Scenario: Draw and delete
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    And User draw signature
    Then User delete signature
    And User validate empty canvas

  @emptycanvas @spv
  Scenario: Empty canvas and delete
    Given User has logged in as SPV
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    Then User delete signature
    And User validate empty canvas

  @mngr
  Scenario: Draw and save
    Given User has logged in as MNGR
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    And User draw signature
    Then User save signature
    And User validate signature

  @mngr
  Scenario: Empty canvas and save
    Given User has logged in as MNGR
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    Then User save signature
    And User validate signature

  @emptycanvas @mngr
  Scenario: Draw and delete
    Given User has logged in as MNGR
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    And User draw signature
    Then User delete signature
    And User validate empty canvas

  @emptycanvas @mngr
  Scenario: Empty canvas and delete
    Given User has logged in as MNGR
    And User at Home Page
    When User click Data in Navbar
    And User click Tanda Tangan Digital in Navbar
    Then User delete signature
    And User validate empty canvas
