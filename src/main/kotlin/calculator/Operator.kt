package calculator

enum class Operator(
    private val value: String,
    private val operator: (Double, Double) -> Double
) {
    PLUS("+", { t, u -> t + u }),
    MINUS("-", { t, u -> t - u }),
    MULTIPLY("*", { t, u -> t * u }),
    DIVIDE("/", { t, u -> if (u == 0.0) throw IllegalArgumentException("0으로 나눌 수 없습니다") else t / u }),
    ;

    fun operate(operand1: Double, operand2: Operand): Double {
        return operator.invoke(operand1, operand2.value)
    }

    companion object {
        fun of(operator: String): Operator {
            return values().findLast { it.value == operator } ?: throw IllegalArgumentException("입력값이 잘못되었습니다. input: $operator")
        }
    }
}
