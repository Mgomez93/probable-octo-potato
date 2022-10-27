Feature: search and place order for products

  Scenario Outline: Search experiance for product in homePage and offerPage
    Given User is on GreenKart landing page
    When User search in homePage shortName of product <Name> and extract actual name of product
    Then User search in offerPage shortName of product <Name>  and extract actual name of product
    And Validate homePage shortName & offerPage shortName is a match.
    
    Examples:
    
    | Name |
    | Tom |
    | Beet |
