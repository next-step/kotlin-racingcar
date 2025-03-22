package calculator

object InputParser {
    fun validateInput(input: String?): List<String> {
        validateNotEmpty(input)
        validateCharacters(input!!)
        val inputList = input.split(Regex("\\s"))
        validateStructure(inputList)
        return inputList
    }

    private fun validateNotEmpty(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("No input was provided")
        }
    }

    private fun validateCharacters(input: String) {
        if (input.contains(Regex("[^0-9+\\-*/\\s]"))) {
            throw IllegalArgumentException("Input contains invalid characters")
        }
    }

    private fun validateStructure(inputList: List<String>) {
        if (inputList.size < MIN_ELEMENTS_AMOUNT || inputList.size % 2 == 0) {
            throw IllegalArgumentException("There should be an odd number of arguments")
        }
    }
}

private const val MIN_ELEMENTS_AMOUNT = 3
