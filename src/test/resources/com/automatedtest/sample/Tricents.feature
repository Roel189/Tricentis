Feature: Tricentis

  @functionals
  Scenario: Fill in all tabs of the form
    Given The user wants to submit a vehicle insurance request
    When The user fills the Vehicle Data Form
    | Audi   | 300      | 02/17/2021  |    3    | Petrol  | 34555 |3424   |3434   |
    And fills the Enter Insurant Data Form
    |John | Philips | 07/10/1980 | Male |Four Season Avenue,39| Denmark | 23543 | Copenhagen | Employee | Speeding |
    And fills Enter Product Data Form
    |06/07/2021 | 30.000.000 |Bonus 1| Full Coverage | Euro Protection | Yes |
    And selects Price Option
    | Gold |
    And fills Send Quote  
    | john@email.com | 32144426 | John198 | Jp12345678 | Jp12345678 | Comment | 
    Then The system notifies that email has been sent

