package calculator.exceptions

sealed class CalculatorException(
    message: String,
) : IllegalArgumentException(message)

class OperationBetweenNumbersException : CalculatorException("Operations should be in between numbers")

class NumberSeparationException : CalculatorException("Numbers should be separated with an operation")
