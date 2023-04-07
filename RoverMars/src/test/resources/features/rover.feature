Feature: Scenario to automate the mars rover challenge

Scenario Outline:
    Given user sets position as <x>  <y> and <letter>
    And enters the process as <direction>
    Then the position is set
    
   Examples:
   |x|y|letter|direction|
   |1|2|1|"LMLMLMLMM"|
   |3|3|2|"MMRMMRMRRM"|
   
   