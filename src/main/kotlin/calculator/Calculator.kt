package calculator

object Calculator {

    private const val DELIMITER = " "

    fun execute(expression: String?): Double {
        if (expression == null || expression.isEmpty()) {
            throw IllegalArgumentException()
        }
        val terms = expression.split(DELIMITER)
        return calculate(
            numbers = parseNumbers(terms),
            operators = parseOperators(terms)
        )
    }

    private fun isNumber(index: Int) = index % 2 == 0

    private fun isOperator(index: Int) = index % 2 == 1

    private fun parseNumbers(list: List<String>) =
        list.filterIndexed { i, _ -> isNumber(i) }.map { it.toDouble() }

    private fun parseOperators(list: List<String>) =
        list.filterIndexed { i, _ -> isOperator(i) }.map { Operator(it) }

    private fun calculate(numbers: List<Double>, operators: List<Operator>): Double {
        var sum = numbers[0]
        operators.forEachIndexed { index, operator ->
            sum = operator.operation().invoke(sum, numbers[index + 1])
        }
        return sum
    }
}
