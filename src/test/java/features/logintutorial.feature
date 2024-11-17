Feature: Login to Tutotial Ninja application with valid credentials

Scenario: Login as user with valid credentials

Given I open the browser
And navigate to login page of tutorial ninja application
When I enter username as "rachithapallikala05@gmail.com" and password as "password"
And I click on Login button
Then I should login successfully