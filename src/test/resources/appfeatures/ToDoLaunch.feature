
Feature: As a user, I should be able to manage my todos effectively.

  Background:
    Given User launches the ToDo application
    When User enters a valid ToDo tasks description
    |Task-1|
    |Task-2|
    |Task-3|
    |Task-4|
    
    
  Scenario:1 As a user I should be able to add a New ToDo Item
    
    Then The new todo items added should appear in the list with the correct description and count
    |Task-1|
    |Task-2|
    |Task-3|
    |Task-4|
    
    
   Scenario:2 As a user I should be able to make a ToDo as Completed
    
    Then User selects the required ToDo list checkbox for completion
    |Task-1|
    |Task-2|
    |Task-3|
    And User clicks on the completed button and verifies the DoTo list for completion
    
    Scenario:3 As a user I should be able to verify the ToDo All filters
   
    Then User selects the required ToDo list checkbox for completion and verifies filter All
     |Task-1|
     |Task-2|
     |Task-3|
     |Task-4|
     
   Scenario:4 As a user I should be able to verify the ToDo Active filter
   
    Then User verifies the ToDo list entered and verifies Active filter 
     |Task-1|
     |Task-2|
     |Task-3|
     |Task-4|
   
     Scenario:5 As a user I can select all the ToDo checkbox at a time
    
    Then User clicks on the down arrow button
    And User verifies all the ToDo list checck box are selected
    
     Scenario:6 As a user I can delete the required ToDo from list
    
    Then User selects a ToDo and click on close button
    |Task-1|
    |Task-2| 
    And User verifes the ToDo is deleted from ToDo list
    

  
