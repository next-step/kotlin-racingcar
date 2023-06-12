package stringcalculator

class StringParser(input: String) {

    companion object {
        private val OPERATOR_REGEX = Regex("[+\\-*/]")
        private val NUMBER_REGEX = Regex("\\d+")
    }

    private val numbers: List<Int>
    private val operators: List<String>

    init {
        validateInput(input)

        numbers = input.split(OPERATOR_REGEX).map { it.toInt() }
        operators = input.split(NUMBER_REGEX).filter { it.isNotEmpty() }

        validateSize()
    }

    fun numbers(): List<Int> {
        return numbers
    }

    fun operators(): List<String> {
        return operators
    }

    private fun validateSize() {
        require(numbers.size == operators.size + 1)
    }

    private fun validateInput(input: String) {
        require(input.isNotBlank()) { "Input cannot be blank" }
        require(input.contains(OPERATOR_REGEX)) { "Input must contain at least one operator" }
    }
}
