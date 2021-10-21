package stringcalculator

class InputValidator {
    fun validate(input: String?): List<String> {
        val validString = validateInputIsNotEmpty(input)
        val splitString = validString.split(" ")

        validateSplitString(splitString)
        return splitString
    }

    @Throws(IllegalArgumentException::class)
    private fun validateInputIsNotEmpty(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력이 비어있습니다.")
        }
        return input
    }

    @Throws(IllegalArgumentException::class)
    private fun validateSplitString(splitString: List<String>) {
        when {
            validateSizeIsNotOdd(splitString) || validateStructure(splitString)
            -> throw IllegalArgumentException("잘못된 구성의 입력 입니다.")
        }
    }

    private fun validateSizeIsNotOdd(input: List<String>): Boolean {
        return input.size % EvenDivider != OddRemainder
    }

    private fun validateStructure(input: List<String>): Boolean {
        val controlList = input.map { it.toIntOrNull() is Int }
        val comparisonList = input.mapIndexed { index, _ -> index % 2 == 0 }
        return controlList != comparisonList
    }

    companion object {
        const val EvenDivider = 2
        const val OddRemainder = 1
    }
}
