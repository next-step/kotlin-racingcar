package calculator

class Calculator {

    fun execute(expression: String?): Double {
        require(!expression.isNullOrBlank())
        val terms = expression.split(DELIMITER)
        return calculate(
            numbers = numbersFromTerms(terms),
            operators = operatorsFromTerms(terms)
        )
    }

    private fun isNumber(index: Int) = index % 2 == 0

    private fun isOperator(index: Int) = index % 2 == 1

    private fun numbersFromTerms(terms: List<String>) =
        terms
            .filterIndexed { i, _ -> isNumber(i) }
            .map { it.toDoubleOrThrowIllegalArgumentException() }

    private fun operatorsFromTerms(terms: List<String>) =
        terms
            .filterIndexed { i, _ -> isOperator(i) }
            .map { Operator.of(it) }

    private fun String.toDoubleOrThrowIllegalArgumentException(): Double {
        return toDoubleOrNull() ?: throw IllegalArgumentException()
    }

    private fun calculate(
        numbers: List<Double>,
        operators: List<Operator>
    ): Double {
        require(numbers.size - operators.size == 1)
        var sum = numbers[0]
        operators.forEachIndexed { index, operator ->
            sum = operator.operate(sum, numbers[index + 1])
        }
        return sum
    }

    companion object {
        private const val DELIMITER = " "
    }
}
