Feature: Validate Amazon website

  Scenario Outline: Go to Amazon and validate Gaming accessories section
    Given the user visits the Amazon website
    When the user clicks on the product of Gaming accessories option <Product>
    And the page should load
    And the user clicks on the first option
    And the user clicks on Add to Cart option
    And the user clicks on Go to Cart option
    And the user clicks on Delete option
    Then the amazon cart should be empty
    Examples:
    | Product       |
    | Headsets      |
    | Keyboards     |
    | Computer mice |
    | Chairs        |

   Scenario: Select one product of Gaming accessories option
     Given the user visits the Amazon website
     And the user select the country Colombia
     When the user select a random product from Gaming accessories option
     Then the page should load