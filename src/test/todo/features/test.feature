Feature: Add Task Action

Scenario: Add New Task 
	Given User is on Home Page
	When User Click New Task Button
	And User Enters New Task Details
	And User Click Save Button
	Then Message Displayed Task Added Successfully

Scenario: Successful Delete Task
	Given User is on Home Page
	When User Click Delete Task Button
	Then Message Displayed Task Deleted Successfully