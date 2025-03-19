# kotlin-racingcar

## Requirements
- Implement a calculator that performs arithmetic operations based on the string input provided by the user
- The calculator executes operations strictly in the order they're entered, ignoring the conventional mathematical operator precedence rules.
- When the input string is "2 + 3 * 4 / 2", the calculator must execute it exactly as entered and produce the result 10.

## Implementations
### Calculator
- [x] Throwing an IllegalArgumentException if the input contains symbols other than arithmetic operators
- [x] Implementing all four arithmetic operations in one integrated feature

### Operator
- [x] enum class with symbol and action
- [x] Addition
- [x] Subtraction
- [x] Multiplication
- [x] Division

### ExpressionParser
- [x] Split input strings to numbers and operators
- [x] Throwing an IllegalArgumentException if the input value is null or blank
- [ ] Throwing an IllegalArgumentException if the input contains symbols other than arithmetic operators