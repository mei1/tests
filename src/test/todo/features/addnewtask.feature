Feature: Add Task Action

Scenario: Add New Task 
	Given User is on Home Page
	When User Click New Task Button
	And User Enters New Task Details
	And User Click Save Button
	Then Message Displayed Task Added Successfully