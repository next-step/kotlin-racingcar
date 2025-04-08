# kotlin-racingcar

## Step 2 - String Calculator

### Functional Requirements

    - Implement a calculator that performs arithmetic operations based on the string input provided by the user.
    - The calculator executes operations strictly in the order they're entered, ignoring the conventional mathematical operator precedence rules. In standard mathematics, multiplication and division have higher precedence than addition and subtraction, but here you should disregard that.
    - For example, when the input string is "2 + 3 * 4 / 2", the calculator must execute it exactly as entered and produce the result 10.

### Implementation details

- Using an enum class for operators
- Should validate input before computing the result
    - validate if the input is blank or null
    - validate if the input has invalid characters
- Compute the result after validation

### Test scope
- Test validation works fine
- Test computation works fine
        
## Step 3 - Car racing

### Functional Requirements

- Implement a simple car racing game with the following rules:
  - Each of the n cars can either move forward or stay still during a given number of rounds.
  - The user should be able to specify the number of cars and the number of rounds.
  - A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
  - The current state of the cars should be displayed on the screen (there are no specific constraints on when to print the output).

### Implementation details

    - InputView class
        - To get input
  
    - ResultView
        - To show the status

    - Car class 
        - Has a name
        - has a position
        - will have a move function
        - will increase the position by 1 if random number >= 4
    
    - CarRace class
        - will accept number of cars in the race and number of rounds in the race
        - startRace function 
        - Need to have at least 2 cars to have the race
        - Need to select at lease 1 round to have the race

  
### Test scope
  
  - Test car class
    - Car has an initial position 0 when created
    - Car moves forward a position if passed random number is >= 4
    - Car remains in the same position if passed random number is < 4

  - Test CarRace class
    - Needs to has at least 2 cars to start the race
    - Needs to have at least 1 round to start the race
    - Race starts successfully if conditions are met

## Step 4 - Car racing(Winner)

### Functional requirements
    - Each car must have a name, and names cannot exceed 5 characters.
    - When printing the progress of each car, display the car's name alongside its movement.
    - Car names should be comma-separated when entered by the user.
    - After the race is complete, display the winners. There can be multiple winners if they reach the same final position.

### Implementation
    - refactor Car and other parts of code to accept string and process 
    - Add a function to determine the winner

### Test scope
    - Make the existing tests pass with the refactor
    - Add new test cases for checking car name length
    - New test for winner logic

