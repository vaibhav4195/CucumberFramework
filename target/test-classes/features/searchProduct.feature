Feature: Search and Place the order for Products
@OffersPage
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart Landing Page
When User searched with Shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers Page
And Validate product name in offers page matches with Landing Page

Examples:
| Name |
| Tom  |
| Beet |