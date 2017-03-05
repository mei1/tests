Feature: Delete Employee Action

Scenario: Delete Employee
	Given User is on Home Page
	When User Select Employee by Id to Delete
	And User Click on Delete Button
	Then Message Displayed Employee Deleted Successfully