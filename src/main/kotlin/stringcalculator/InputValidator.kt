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

    private fun validateSplitString(splitString: List<String>) {
        checkInputSizeIsOdd(splitString)
        checkInputStructure(splitString)
    }

    @Throws(IllegalArgumentException::class)
    private fun checkInputSizeIsOdd(input: List<String>) {
        if (input.size % EvenDivider != OddRemainder) {
            throw IllegalArgumentException("입력 항의 갯수가 올바르지 않습니다.")
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun checkInputStructure(input: List<String>) {
        val controlList = input.map { it.toIntOrNull() is Int }
        val comparisonList = input.mapIndexed { index, _ -> index % 2 == 0 }
        if (controlList != comparisonList) {
            throw IllegalArgumentException("입력된 식의 구성이 올바르지 않습니다.")
        }
    }

    companion object {
        const val EvenDivider = 2
        const val OddRemainder = 1
    }
}
