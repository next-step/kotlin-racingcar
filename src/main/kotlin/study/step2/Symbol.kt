package study.step2

enum class Symbol(val s: String, val operate: (Double, Double) -> Double) {
    ADDITION("+", { operand1: Double, operand2: Double -> operand1 + operand2 }),
    SUBTRACTION("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLICATION("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVISION("/", { operand1, operand2 ->
        require(operand2 != 0.0) { "잘못된 계산식 입니다" }
        operand1 / operand2
    });

    companion object {
        fun of(s: String): Symbol {
            return when (s) {
                "+" -> ADDITION
                "-" -> SUBTRACTION
                "*" -> MULTIPLICATION
                "/" -> DIVISION
                else -> throw IllegalArgumentException("[$s]는 사칙연산 기호가 아님")
            }
        }
    }
}
