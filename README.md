# kotlin-racingcar

## [Step 1] - Kotlin Basics

1. Convert Person Java bean to Kotlin data class preserving the functionality
2. Test the following data class characteristics:
   Named arguments
   Nullable types
   Default arguments
   Data classes equality
   Data classes copying

## [Step 2] - String Calculator

### Implementation

1. Implement Calculator class with such operations as: addition, subtraction, multiplication, and division
2. Parse the input string into numbers and operators
3. Process input sequentially from left to right
4. Implement error handling for invalid inputs

### Testing

- Validate correct execution of sequential operations.
- Test with various input formats, including edge cases.
- Proper handling of invalid expressions and errors.

## [Step 3] - Car Racing

### Implementation

1. Implement a Car class with current position
2. Create a Model class that controls the race, including the number of cars and the number of rounds.
3. During each round, each car will either move forward or stay still based on a randomly generated number between 0 and 9
4. Display the current state of each car after each round 
5. Allow the user to specify the number of cars and the number of rounds at the start of the game.

Testing
- Validate correct movement of cars based on random number generation
- Test with different numbers of cars and rounds
- Test the model methods invocation in a wrong sequence
- Handle input edge cases, such as zero cars or zero rounds

## [Step 4] - Car Racing (Winner)
1. Add a name property to Car with constraint of 5 characters
2. Implement car name input flow and test handle incorrect input (separation not by comma)
3. Update CarRacing view to display the car’s name alongside its movement
4. Define winners (multiple winners if final position is same)
5. Update CarRacing view to show winners