Feature: Add Id Card Action

Scenario: Add New Id Card 
	Given User is on Home Page
	When User Select Employee by Id to add Id Card Data
	And User Enters Id Card Details
	And User Click Save Id Card Button
	Then Message Displayed Id Card Added Successfully