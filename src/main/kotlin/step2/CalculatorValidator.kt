package step2

object CalculatorValidator {

    private const val EVEN_NUMBER_DENOMINATOR = 2
    private const val EVEN_NUMBER_REMAINDER = 0
    private const val MINIMUM_SIZE = 3

    fun validateSize(size: Int) {
        require(size >= MINIMUM_SIZE) { ErrorMessage.MINIMUM_SIZE_REQUIREMENT_MSG.message }
        require(size % EVEN_NUMBER_DENOMINATOR != EVEN_NUMBER_REMAINDER) { ErrorMessage.ODD_SIZE_REQUIREMENT_MSG.message }
    }

    fun validateInput(input: String?): String {
        require(!input.isNullOrBlank()) { ErrorMessage.NULL_OR_BLANK_ERROR_MSG.message }
        return input
    }
}
