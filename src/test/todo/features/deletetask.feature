Feature: Delete Task Action

Scenario: Delete Task
	Given User is on Home Page
	When User Select Task by Task Id to Delete
	And User Click on Confirmation Button
	Then Message Displayed Task Deleted Successfully