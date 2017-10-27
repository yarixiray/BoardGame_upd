Feature: BoardGameTest

Scenario: boardgamegeek

Given I am on the homepage
When Open the game collection of a user
And Go to the page of one of the games (chosen at random)
Then Check the information about the game - especially the poll about Language Dependence
And Verify that the most voted Language Dependence level is presented on the game's page


