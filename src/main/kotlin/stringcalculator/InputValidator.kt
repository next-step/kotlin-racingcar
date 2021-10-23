package stringcalculator

class InputValidator {
    fun validate(input: String?): List<String> {
        val splitString = trySplit(input)
        checkSizeIsOdd(splitString)
        checkFormulaIsCorrect(splitString)
        return splitString
    }

    @Throws(IllegalArgumentException::class)
    private fun trySplit(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE)
        }

        return input.split(SPLIT_DELIMITER)
    }

    @Throws(IllegalArgumentException::class)
    private fun checkSizeIsOdd(input: List<String>) {
        if (input.size % EVEN_DIVIDER != ODD_REMAINDER) {
            throw IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE)
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun checkFormulaIsCorrect(input: List<String>) {
        val controlList = input.map { it.toIntOrNull() is Int }
        val comparisonList = input.mapIndexed { index, _ -> index % EVEN_DIVIDER == EVEN_REMAINDER }
        if (controlList != comparisonList) {
            throw IllegalArgumentException(INVALID_FORMULA_ERROR_MESSAGE)
        }
    }

    companion object {
        const val EVEN_DIVIDER = 2
        const val ODD_REMAINDER = 1
        const val EVEN_REMAINDER = 0

        const val SPLIT_DELIMITER = " "

        const val EMPTY_INPUT_ERROR_MESSAGE = "입력이 비어있습니다."
        const val INVALID_SIZE_ERROR_MESSAGE = "입력 항의 갯수가 올바르지 않습니다."
        const val INVALID_FORMULA_ERROR_MESSAGE = "입력된 식의 구성이 올바르지 않습니다."
    }
}
