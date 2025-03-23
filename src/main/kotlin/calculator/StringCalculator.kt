package calculator

class StringCalculator(
    input: String,
) {
    private val operands = mutableListOf<Int>()
    private val operators = mutableListOf<ArithmeticOperator>()

    init {
        require(input.isNotBlank()) {
            "Input must not be null or empty."
        }

        parseInput(input)
    }

    fun calculate() =
        operators.foldIndexed(operands.first()) { index, acc, operator ->
            operator.operate(acc, operands[index + 1])
        }

    private fun parseInput(input: String) {
        val splitInput =
            input.trim()
                .split(DELIMITER)
                .filter { it.isNotBlank() }

        require(splitInput.size >= MINIMUM_SPLIT_LENGTH) {
            "Input is not a valid expression. Must have at least two operands and one operator."
        }

        createExpression(splitInput)

        require(operands.size == operators.size + 1) {
            "Input is not a valid expression. Check the number of operators."
        }
    }

    private fun createExpression(splitInput: List<String>) {
        splitInput.chunked(2).forEach { pair ->
            val operand = pair[0]
            val operator = pair.getOrNull(1)

            parseOperand(operand)
            operator?.let {
                parseOperator(it)
            }
        }
    }

    private fun parseOperand(input: String) {
        val value =
            input.toIntOrNull()
                ?: throw IllegalArgumentException("Invalid operand: $input. Must be a number.")
        operands.add(value)
    }

    private fun parseOperator(input: String) {
        val operator = ArithmeticOperator.from(input)
        operators.add(operator)
    }

    companion object {
        private const val DELIMITER = " "
        private const val MINIMUM_SPLIT_LENGTH = 3
    }
}
