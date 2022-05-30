Feature: Place the order of Products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and Offers page

Given User is on GreenCart Landing pages
When user searched with Shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then user proceeds to Checkout and Validate the <Name> items in checkout page
And verify user has ability to enter promocode and place the order

Examples:
| Name  |
| Tom   |