package stringcalculator

private const val OPERATOR_REGEX = "[+\\-*/]"
private const val NUMBER_REGEX = "\\d+"

class StringParser(input: String) {
    private val numbers: List<Int>
    private val operators: List<String>

    init {
        validateInput(input)

        numbers = input.split(Regex(OPERATOR_REGEX)).map { it.toInt() }
        operators = input.split(Regex(NUMBER_REGEX)).filter { it.isNotEmpty() }

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
        require(input.isNotBlank())
        require(input.contains(Regex(OPERATOR_REGEX)))
    }
}