Feature: Update Id Card Action

Scenario: Update Existing Id Card 
	Given User is on Home Page
	When User Click Existing Id Card by Id
	And User Edit Id Card Details
	And User Click Update Id Card Button
	Then Message Displayed Id Card Updated Successfully