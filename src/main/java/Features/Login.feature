Feature: Validate login feature

Background:
Given User is in login page

@sanity
 Scenario Outline:Login
   When User enters valid  "<username>" and "<password>"
   Then User should land on homepage
   
   Examples:
       |username|password|
       |claxmirao@gmail.com|687beachparkblvd|
       |aahla@gmail.com|aahla123|
       |aarav@gmail.com|aarav123|
  
  @regression
 Scenario:
   When User enters invalid username and password
  Then User should see error message
  
  @egression
  Scenario: check scores
  When User enters invalid username and password
  Then User should see scores
  |scores| names|
  |100| Ameer|
  |200| Emily|
  |300| Abeer|
  |400| Anirudh|
  
  