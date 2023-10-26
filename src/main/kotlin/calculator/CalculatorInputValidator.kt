package calculator

class CalculatorInputValidator {
    fun validate(input: String?) {
        validateNotNullAndNotBlank(input)
    }

    private fun validateNotNullAndNotBlank(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Input should not be null or blank.")
        }
    }
}
