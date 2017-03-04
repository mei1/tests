Feature: Delete Task Action

Scenario: Delete Task
	Given User is on Home Page
	When User Click Delete Task Button by Task Id
	Then Message Displayed Task Deleted Successfully