package calculator

private const val EXPRESSION_DELIMITER = " "
private const val EVEN_AND_ODD_STANDARD = 2
private const val NUMBER_POSITION = 0

class StringCalculator(
    private val expression: String,
) {
    init {
        require(expression.isNotBlank())
    }

    fun calculate(): Int {
        val numbersAndOperators = expression.split(EXPRESSION_DELIMITER)
            .withIndex()
            .partition { it.index % EVEN_AND_ODD_STANDARD == NUMBER_POSITION }

        val numbers = numbersAndOperators.first.map { it.value.toInt() }.toMutableList()
        val operators = numbersAndOperators.second.map { Operator.of(it.value) }

        var sum = numbers.removeFirst()
        operators.forEach { operator ->
            sum = operator.operate(sum, numbers.removeFirst())
        }

        return sum
    }
}
