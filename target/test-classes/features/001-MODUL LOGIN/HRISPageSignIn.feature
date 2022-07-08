#Author: mnaauval@gmail.com
Feature: Sign in page

  Scenario: Valid URL
    Given User open browser
    When User input url "https://dev.ptdika.com/employee/panel/login/"
    Then User validate page "https://dev.ptdika.com/employee/panel/login/"

  Scenario: Invalid URL
    Given User open browser
    When User input url "https://dev.ptdika.com/employee/panel/signin/"
    Then User validate page "https://dev.ptdika.com/employee/panel/signin/"
