package stringcalculator

class InputValidator {
    fun validate(input: String?): List<String> {
        val validString = validateInputIsNotEmpty(input)
        val splitString = validString.split(" ")
        return validateSplitStringIsCorrectlyStructured(splitString)
    }

    @Throws(IllegalArgumentException::class)
    private fun validateInputIsNotEmpty(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력이 비어있습니다.")
        }
        return input
    }

    @Throws(IllegalArgumentException::class)
    private fun validateSplitStringIsCorrectlyStructured(splitString: List<String>): List<String> {
        when {
            validateSize(splitString) -> throw IllegalArgumentException("잘못된 구성의 입력 입니다.")
            validateStructure(splitString) -> throw IllegalArgumentException("잘못된 구성의 입력 입니다.")
        }

        return splitString
    }

    private fun validateSize(input: List<String>): Boolean {
        return input.size % 2 == 0
    }

    private fun validateStructure(input: List<String>): Boolean {
        val controlList = input.map { it.toIntOrNull() is Int }
        val comparisonList = input.mapIndexed { index, _ -> index % 2 == 0 }
        return controlList != comparisonList
    }
}
