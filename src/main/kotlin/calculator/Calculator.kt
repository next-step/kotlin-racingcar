package calculator

class Calculator {

    fun calculate(operation: String?): Double {
        require(!operation.isNullOrBlank())
        val (operator, numbers) = partitionFormula(operation)
        require(
            operator.isNotEmpty() &&
                    numbers.isNotEmpty() &&
                    numbers.size == operator.size + DEFAULT_OFFSET
        )
        val first = numbers.first()
        val otherNumbers = numbers.drop(DEFAULT_OFFSET)
        return otherNumbers.foldIndexed(first) { index, num, total ->
            Operator(operator[index]).operate(num, total)
        }
    }

    private fun partitionFormula(operation: String) =
        operation.split(DELIMITER_WHITE_SPACE)
            .partition { it in Operator.OPERATORS }
            .let { it.first to it.second.mapNotNull { num -> num.toDoubleOrNull() } }

    companion object {
        private const val DELIMITER_WHITE_SPACE = " "
        private const val DEFAULT_OFFSET = 1
    }
}