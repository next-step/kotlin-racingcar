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
- Round
  - Round must be between 1 and 10
  - If round is 0, it cannot proceed
- Name
  - Name must not be null or blank
  - Name length must be in between 1 and 5

- Car
  - Can move forward or stay still
  - Moving policy - if random number is below 4, stay still, else move forward

- Cars
  - Collection for list of cars
  - Calculate current winners
  - Let all cars move

- RacingGame
  - Create racing game with car names and rounds
  - Begin racing game for all cars by moving them
  - Collect results produced by each round

- View
  - Request car names
  - Request number of rounds
  - Print current position of the cars
  - Print final winners of the race
