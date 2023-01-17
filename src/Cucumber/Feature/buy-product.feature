Feature: BuyNewProduct
  Scenario Outline: Buy new product
    Given user go on website "https://mystore-testlab.coderslab.pl/index.php"
    And logged in with email "<email>" and password "<password>"
    When user choose product "<productName>"
    And user choose size "<size>"
    And user add five pieces
    And user cliked add product
    And user confirmed address to send
  And choose pick up and payment method
    Then cliked to order with an obligation to pay
    And make screenshoot with order confirmation and amount

    Examples:
      |email              |password |productName                  |size   |
      |snieg@gmail.com    |Test123  |Hummingbird Printed Sweater  |M      |