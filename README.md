# kotlin-racingcar

## Functional Requirements

    - Implement a calculator that performs arithmetic operations based on the string input provided by the user.
    - The calculator executes operations strictly in the order they're entered, ignoring the conventional mathematical operator precedence rules. In standard mathematics, multiplication and division have higher precedence than addition and subtraction, but here you should disregard that.
    - For example, when the input string is "2 + 3 * 4 / 2", the calculator must execute it exactly as entered and produce the result 10.

## Implementation details

- Using an enum class for operators
- Should validate input before computing the result
    - validate if the input is blank or null
    - validate if the input has invalid characters
- Compute the result after validation

## Test scope
- Test validation works fine
- Test computation works fine
        
