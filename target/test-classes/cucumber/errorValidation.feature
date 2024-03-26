
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on youtube page
    When On youtube page it will paste <content> and click on search button
    And it will go to next page,play video and click on home button and go to signinpage
    Then error message is displayed it use <email> and <content>

    Examples: 
      | email          | content   | 
      | wc@gmail.com   | amazon    | 
     
