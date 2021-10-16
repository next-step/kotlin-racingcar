package calculator.domain.vo

data class Expression(
    private val left: Term,
    private val right: Term,
    private val operator: Operator,
) {
    fun calculate() = Term(operator.calculate(left.value, right.value))
}
