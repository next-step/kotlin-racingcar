package calculator

private const val DELIMITER = " "

class Expression(input: String) {
    private val numbers: List<Int>
    private val operators: List<Operation>

    init {
        val tokens = input.split(DELIMITER)

        if (tokens.size % 2 == 0) throw IllegalArgumentException("수식이 잘못 되었습니다.")

        numbers = extractNumbers(tokens)
        operators = extractOperators(tokens)
    }

    fun evaluate(): Int {
        var result = numbers[0]

        for (index in operators.indices) {
            val nextNumber = numbers[index + 1]
            result = operators[index].apply(result, nextNumber)
        }

        return result
    }

    private fun extractNumbers(tokens: List<String>): List<Int> {
        return tokens.filterIndexed { index, _ -> index % 2 == 0 }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자가 있습니다.: $it") }
    }

    private fun extractOperators(tokens: List<String>): List<Operation> {
        return tokens.filterIndexed { index, _ -> index % 2 == 1 }.map { Operation.from(it) }
    }
}
