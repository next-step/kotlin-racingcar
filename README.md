# kotlin-racingcar

## [Step 2] - String Calculator

1. Validate input
    - Throw `IllegalArgumentException` when input is null or empty
2. Parse input to operands and operators
    - Throw `IllegalArgumentException` when strings other than numbers are given
    - Throw `IllegalArgumentException` when input contains symbols other than arithmetic operators
    - Throw `IllegalArgumentException` when input is not a valid expression
3. Use enum to calculate with two numbers
4. Calculate according to given operands and operators in order
    - Throw `IllegalArgumentException` when division by 0

## [Step 3] - Car Racing
- Car
  - Can move forward or stay still
  - Moving policy - if random number is below 4, stay still, else move forward

- Input Number
  - Used for number of cars and number of rounds
  - Number must be positive and less or equal to 10

- View
  - Request number of cars
  - Request number of rounds
  - Print current position of the cars
