# kotlin-racingcar

# Car Racing
## Requirements
- Each of the n cars can either move forward or stay still during a given number of rounds.
- The user should be able to specify the number of cars and the number of rounds.
- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
- The current state of the cars should be displayed on the screen (there are no specific constraints on when to print the output).

## Implementations
### Car
- [x] Has position
- [x] Move forward based on the number

### InputView
- [x] Get the number of cars
- [x] Get the number of rounds

### OutputView
- [x] Print race results

---

# String Calculator
## Requirements
- Implement a calculator that performs arithmetic operations based on the string input provided by the user
- The calculator executes operations strictly in the order they're entered, ignoring the conventional mathematical operator precedence rules.
- When the input string is "2 + 3 * 4 / 2", the calculator must execute it exactly as entered and produce the result 10.

## Implementations
### Calculator
- [x] Throwing an IllegalArgumentException if the input contains symbols other than arithmetic operators
- [x] Implementing all four arithmetic operations in one integrated feature
- [x] Connect Calculator and ExpressionParser

### Operator
- [x] enum class with symbol and action
- [x] Addition
- [x] Subtraction
- [x] Multiplication
- [x] Division

### ExpressionParser
- [x] Split input strings to numbers and operators
  - [x] numbers should be returned as Int
  - [x] Throwing an IllegalArgumentException if the number is not able to change to Int
- [x] Throwing an IllegalArgumentException if the input value is null or blank
- [x] Throwing an IllegalArgumentException if the input contains symbols other than arithmetic operators
