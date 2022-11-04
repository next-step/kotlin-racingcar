package calculator

class Calculator {

    fun calculate(operation: String?) {
        require(!operation.isNullOrBlank())
        val (operator, numbers) = partitionFormula(operation)
        require(operator.size == numbers.size + DEFAULT_OFFSET)
        Operator("")
    }

    private fun partitionFormula(operation: String) =
        operation.split(DELIMITER_WHITE_SPACE)
            .partition { it in Operator.OPERATORS }
            .let { it.first to it.second.mapNotNull { it.toIntOrNull() } }

    companion object {
        private const val DELIMITER_WHITE_SPACE = " "
        private const val DEFAULT_OFFSET = 1
    }
}