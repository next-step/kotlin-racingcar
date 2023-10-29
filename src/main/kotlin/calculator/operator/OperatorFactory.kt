package calculator.operator

object OperatorFactory {
    private val operators = listOf(
        PlusOperator, MinusOperator, MultiplyOperator, DivideOperator,
    )

    fun findOperator(operatorSymbol: String): Operator {
        return operators.find { it.canHandle(operatorSymbol) }
            ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
    }
}
