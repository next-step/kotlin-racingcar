package calculator

enum class Operator(
    private val operator: (Double, Double) -> Double
) {
    PLUS({ t, u -> t + u }),
    MINUS({ t, u -> t - u }),
    MULTIPLY({ t, u -> t * u }),
    DIVIDE({ t, u -> if (u == 0.0) throw IllegalArgumentException("0으로 나눌 수 없습니다") else t / u }),
    ;

    fun operate(operand1: Double, operand2: Double): Double {
        return operator.invoke(operand1, operand2)
    }

    companion object {
        fun toOperator(operator: String): Operator? = when (operator) {
            "+" -> PLUS
            "-" -> MINUS
            "*" -> MULTIPLY
            "/" -> DIVIDE
            else -> null
        }
    }
}
