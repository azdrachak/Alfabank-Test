Feature: Test that product name is the same for search and product page

  @All
  @Phones
  Scenario: Test Samsung phone with max price
    Given I open Yandex home page
    When I click Market link
    And Open Electronics department
    And Open Mobile Phone page
    And Set filter to "Samsung"
    And Set max price to "40000"
    And Open first search result
    Then Product name from search is the same as From Product page

  @All
  @Headsets
  Scenario: Test Beats headset with min and max price
    Given I open Yandex home page
    And I click Market link
    And Open Electronics department
    And Open Headsets page
    And Set filter to "Beats"
    And Set min price to "17000"
    And Set max price to "25000"
    And Open first search result
    Then Product name from search is the same as From Product page