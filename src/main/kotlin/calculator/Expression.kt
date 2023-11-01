package calculator

data class Expression(
    val left: Long,
    val operator: Operator,
    val right: Long,
) {
    fun calculate(): Long = operator.operation(left, right)
}
