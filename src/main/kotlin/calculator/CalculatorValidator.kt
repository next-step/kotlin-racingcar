package calculator

object CalculatorValidator {

    fun validateInput(input: String?): String {
        require(!input.isNullOrBlank()) { ErrorMessage.NULL_OR_BLANK_ERROR_MSG.message }
        require(input.matches(Operation.VALID_NUMBER_PATTERN)) { ErrorMessage.INVALID_INPUT_ERROR_MSG.message }
        return input
    }
}
