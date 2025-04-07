# kotlin-racingcar

## Functional Requirements

1. Input Format
   - Accept a single string representing a mathematical expression.
   - The string contains integers and arithmetic operators: `+, -, *, /.`
   - Tokens (numbers and operators) are separated by whitespace.

2. Order of Execution
   - Evaluate operations strictly from left to right.
   - ❗ Ignore mathematical operator precedence (e.g., multiplication/division doesn’t take priority).
   - Example: "2 + 3 * 4 / 2" → Result: 10

3. Supported Operators
   - Addition: +
   - Subtraction: -
   - Multiplication: *
   - Division: /

4. Input Validation
   - Throw IllegalArgumentException if:
     - The input is null or blank.
     - The input contains invalid characters (e.g., symbols other than numbers, operators, or spaces).
