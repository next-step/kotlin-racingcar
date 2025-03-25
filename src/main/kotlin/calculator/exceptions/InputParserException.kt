package calculator.exceptions

sealed class InputParserException(
    message: String,
) : IllegalArgumentException(message)

class BlankInputException : InputParserException("No input was provided")

class InvalidCharacterException : InputParserException("Input contains invalid characters")

class NotEnoughElementsException : InputParserException("There should be at least 2 elements")

class EvenNumberElementsException : InputParserException("There should be an odd number of elements")
