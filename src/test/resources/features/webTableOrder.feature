@wip
Feature: Web table user order feature

  TC:01

  Background: user logged in and user in order page
    Given user in order page

  Scenario: user should be able to place order and order seen in List of All Orders Table

    When user selects product type

    And user enters quantity

    And user enters customer name
    And user enters street
    And user enters city
    And user enters state
    And user enter zip
    And user selects card type
    And user enters card number
    And user enters expiry date
    And user clicks process order button
    Then user should see new order in the table on *view all orders* page



