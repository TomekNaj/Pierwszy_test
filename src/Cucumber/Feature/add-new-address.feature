Feature: AddAddress
  Scenario Outline: Add first address
    Given register user fill in New Address at "https://mystore-testlab.coderslab.pl/index.php" website
    And user is logged in with email "<email>" and password "<password>"
    When user clicked at Add Address buttom
    And user fill in alias "<alias>", address "<address>", city "<city>", post code "<postCode>", country "<country>", phone "<phone>"
    Then new address is data is correct and contains "<alias>", "<address>", "<city>", "<postCode>", "<country>", "<phone>"

    Examples:
      |email              |password |alias |address   |city   | postCode |country          |phone      |
      |snieg@gmail.com    |Test123  |Snow  |Nijaka 23 |Klony  |12-145    |United Kingdom   |5689875974 |