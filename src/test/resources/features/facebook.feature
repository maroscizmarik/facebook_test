Feature: Facebook status

  As a Facebook user
  I want to log in and update my status
  So that people can see my latest thoughts

#Test scenario represent one flow of user's interaction with Application as it is described in BDD approach

Scenario: Update status on Facebook
  Given User is logged in to Facebook
  And User checks successful login
  And User navigates to profile page
  When User updates status and checks the result
  Then User is logged out from Facebook
  And User checks successful logout