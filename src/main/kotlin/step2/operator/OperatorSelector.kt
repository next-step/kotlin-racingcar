package step2.operator

class OperatorSelector {
    private val plusOperator = PlusOperator()
    private val minusOperator = MinusOperator()
    private val multiplyOperator = MultiplyOperator()
    private val divideOperator = DivideOperator()

    fun get(operator: String): Operator {
        return when (operator) {
            "+" -> {
                plusOperator
            }

            "-" -> {
                minusOperator
            }

            "/" -> {
                divideOperator
            }

            "*" -> {
                multiplyOperator
            }

            else -> throw IllegalArgumentException("연산자 자리에 다른 문자가 입력되었습니다.")
        }
    }
}