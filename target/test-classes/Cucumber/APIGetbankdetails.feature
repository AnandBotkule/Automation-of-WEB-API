@tagurpage
Feature: API validation
I want to use this template for my feature file

@APIvalidation
Scenario: Get API Validation
Given Get API Url
When Request body Specification
And Response body Specification
And Sending the get API call with response 401
Then 401 and "User login required" message is displayed