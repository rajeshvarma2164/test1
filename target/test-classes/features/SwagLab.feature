Feature: Place the order for Products in Sawglab

  @PlaceOrderSawglab
  Scenario Outline: Search and add product to cart
    Given User login to Sawglab with "<Username>" and "<Password>"
    When user searched with "<Product name>" and adds to cart
    And Adds 1 items to cart
    Then User Checkout and validate the "<Product name>" items in checkout page
    And User enters "<Name>" and  "<Last Name>" and  "<Zipcode>" for delivery
    Then verify user has ability to finsh the order

    Examples: 
      | Username      | Password     | Product name             | Name | Last Name | Zipcode |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket | Raj  | var       |  638002 |

  @PlaceOrderSawglabmutiple
  Scenario Outline: Search and add product to cart
    Given User login to Sawglab with "<Username>" and "<Password>"
    When user searched with "<Product name>" and adds to cart
    And Adds 1 items to cart
    Then User Checkout and validate the "<Product name>" items in checkout page
    And User enters "<Name>" and  "<Last Name>" and  "<Zipcode>" for delivery
    Then verify user has ability to finsh the order

    Examples: 
      | Username      | Password     | Product name          | Name    | Last Name | Zipcode |
      | standard_user | secret_sauce | Sauce Labs Onesie     | monkey  | kingkong  |  565855 |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket | Gorilla | Mamoth    |  232032 |
