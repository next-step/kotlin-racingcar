package calculator

data class Expression(
    val left: Long,
    val right: Long,
    val operator: Operator
)
