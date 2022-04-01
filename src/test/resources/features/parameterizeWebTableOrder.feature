@wip2
Feature: Web table user order feature multiple parameters

  TC:02

  Background: user logged in and user in order page
    Given user in order page

  Scenario Outline: user should be able to place order and order seen in List of All Orders Table

    When user selects product type <productType>
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<streetName>"
    And user enters city "<cityName>"
    And user enters state "<stateName>"
    And user enter zip <zipCode>
    And user selects card type "<cardType>"
    And user enters card number "<cardNumber>"
    And user enters card expiry date "<expiry/date>"
    And user clicks process order button
    Then user should see customer name in the table on *view all orders* page

    Examples:
      | productType | quantity | customerName   | streetName      | cityName       | stateName | zipCode | cardType         | cardNumber   | expiry/date |
      | 1           | 1        | Mila Kunis     | Hamburg st      | Belgrade       | Sting     | 96012   | Visa             | 123456789012 | 12/27       |
      | 2           | 2        | Jannet Jackson | Asik koy kovesi | London         | Adaban    | 90873   | MasterCard       | 123478901256 | 06/29       |
      | 0           | 3        | Apple Cucumber | Lincoln street  | Paris          | Bakers    | 67543   | American Express | 890112345672 | 02/28       |
      | 1           | 4        | Sergio Ramos   | Martin Luther   | Constantinople | Jonson    | 99764   | MasterCard       | 123457890162 | 11/29       |
      | 2           | 5        | Adalat Sadakat | Michael Jason   | Tashkent       | Hunt      | 34684   | Visa             | 901234567812 | 10/23       |
      | 1           | 6        | Selmia Kamila  | Lebron Kamin    | Kiev           | Ming      | 98763   | MasterCard       | 156789012234 | 09/25       |
      | 0           | 7        | Jaren Gurdova  | Saddam Ali      | Ashgabat       | Maliska   | 99712   | American Express | 789012345612 | 02/25       |


