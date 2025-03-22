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

### Calculator

- [x] Throwing an IllegalArgumentException if the input contains symbols other than arithmetic operators
- [x] Implementing all four arithmetic operations in one integrated feature
- [x] Connect Calculator and ExpressionParser