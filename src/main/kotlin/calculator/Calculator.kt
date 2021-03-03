package calculator

class Calculator {

    fun execute(expression: String?): Double {
        require(!expression.isNullOrBlank())
        val terms = expression.split(DELIMITER)
        return calculate(
            numbers = getNumbers(terms),
            operations = getOperations(terms)
        )
    }

    private fun isNumber(index: Int) = index % 2 == 0

    private fun isOperator(index: Int) = index % 2 == 1

    private fun getNumbers(list: List<String>) =
        list
            .filterIndexed { i, _ -> isNumber(i) }
            .map { it.toDoubleOrThrowIllegalArgumentException() }

    private fun getOperations(list: List<String>) =
        list
            .filterIndexed { i, _ -> isOperator(i) }
            .map { Operator.operation(it) }

    private fun String.toDoubleOrThrowIllegalArgumentException(): Double {
        return toDoubleOrNull() ?: throw IllegalArgumentException()
    }

    private fun calculate(
        numbers: List<Double>,
        operations: List<(Double, Double) -> Double>
    ): Double {
        require(numbers.size - operations.size == 1)
        var sum = numbers[0]
        operations.forEachIndexed { index, operation ->
            sum = operation(sum, numbers[index + 1])
        }
        return sum
    }

    companion object {
        private const val DELIMITER = " "
    }
}
