package calculator

object Operators {
    private val operators = mapOf(
        Operator.PLUS.type to Operator.PLUS,
        Operator.MINUS.type to Operator.MINUS,
        Operator.MULTI.type to Operator.MULTI,
        Operator.DIVIDE.type to Operator.DIVIDE
    )

    fun getOperator(stringOperate: String): Operator {
        return operators[stringOperate] ?: throw IllegalArgumentException("+,-,/,* 연산만 가능합니다.")
    }
}
