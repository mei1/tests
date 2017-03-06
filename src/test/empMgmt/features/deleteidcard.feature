Feature: Delete Id Card Action

Scenario: Delete Id Card
	Given User is on Home Page
	When User Select Id Card by Id to Delete
	And User Click on Delete Id Card Button
	Then Message Displayed Id Card Deleted Successfully