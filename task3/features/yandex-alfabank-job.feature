Feature: Save about job in file

  Scenario: Find Alfa-Bank in Yandex and copy text from jobs page
    Given I am on the Yandex home page
    When I search Альфа-Банк
    And Click link to Alfa-Bank
    And Click link to Вакансии
    And Open о работе в банке section
    Then Benefits text is saved ito the file