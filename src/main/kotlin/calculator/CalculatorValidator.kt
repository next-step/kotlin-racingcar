package calculator

object CalculatorValidator {

    private val VALID_NUMBER_PATTERN = "^-?\\d+( [+\\-*/] -?\\d+)+\$".toRegex()

    fun validateInput(input: String?): String {
        require(!input.isNullOrBlank()) { ErrorMessage.NULL_OR_BLANK_ERROR_MSG.message }
        require(input.matches(VALID_NUMBER_PATTERN)) { ErrorMessage.INVALID_INPUT_ERROR_MSG.message }
        return input
    }
}
