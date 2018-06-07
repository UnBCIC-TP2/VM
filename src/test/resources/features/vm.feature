@VMTest
Feature: The behavior of a vending machine. 

Background:
 Given that a bottle of beer is 75 cents
 
Scenario: Only entering 50 cents and stopping.
 When I introduce 50 cents
 Then the total in coins must be 50
 
 Scenario: Buying a beer!
  When I introduce 75 cents
  And ask for a beer
  Then the system should print a message GET YOUR DRINK and the total in coins must be 0
 
Scenario: Trying to buy a bottle of beer with only 25 cents.
 When I introduce 25 cents 
 And ask for a beer without enough money
 Then the system should print a message NOT ENOUGH MONEY and the total in coins must be 25 
 
Scenario: Trying to buy two beers after inserting one real!
 When I introduce 1 real (100 cents) 
 And ask for two beers
 Then the system should print a message NOT ENOUGH MONEY and the total in coins must be 25
 
 Scenario: Trying of buy one beer after inserting one real!
  When I introduce 1 real (100 cents)
  And ask for a beer
  And ask for the change
  Then the system should print a message GET YOUR DRINK and the total in coins must be 0 