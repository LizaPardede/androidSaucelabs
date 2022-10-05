Feature: Buying product from Saucelabs apps

  Scenario: Buy product from Homepage
    Given user is on homepage
    When user click product image
    And user choose blue color
    And user update quantity
    And user click Buy button
    Then user validate product added to cart successfully

