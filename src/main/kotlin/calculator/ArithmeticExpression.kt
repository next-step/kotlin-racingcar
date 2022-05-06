package calculator

private const val DELIMITER = " "

data class ArithmeticExpression(
    private val expression: String
) {
    val operators: List<Operator>

    val operands: List<Double>

    init {
        require(expression.isNotBlank() && expression.isNotEmpty()) {"연산식은 공백이 될수 없습니다."}
        val split = expression.split(DELIMITER)

        operators = split.filterIndexed { i, _ ->  i % 2 == 1}
                         .map { Operator.find(it) }
        operands = split.filterIndexed { i, _ ->  i % 2 == 0}
                        .map { s: String ->  s.toDouble() }
    }

}
