Feature: BoardGameTest

Scenario: Open the game collection of a user

Given I am on the homepage
When login as user with password
And navigate  to the "My Geek" menu
And click on the "Collection"
Then Board Game Collection page is open


Scenario: Go to the page of one of the games, chosen at random

When game is chosen
Then game page is open, the most voted Language Dependence level is presented


Scenario: Check the information about the game - especially the poll about Language Dependence

Given url of the api
#When send the request
#Then the response is received