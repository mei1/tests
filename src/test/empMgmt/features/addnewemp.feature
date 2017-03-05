Feature: Add Employee Action

Scenario: Add New Employee 
	Given User is on Home Page
	When User Click New Employee Button
	And User Enters New Employee Details
	And User Click Save Button
	Then Message Displayed Employee Added Successfully