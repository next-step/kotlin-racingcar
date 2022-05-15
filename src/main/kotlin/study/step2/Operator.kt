package study.step2

enum class Operator(val s: String) {
    ADDITION("+") {
        override fun operate(operand1: Double, operand2: Double): Double {
            return operand1 + operand2
        }
    },
    SUBTRACTION("-") {
        override fun operate(operand1: Double, operand2: Double): Double {
            return operand1 - operand2
        }
    },
    MULTIPLICATION("*") {
        override fun operate(operand1: Double, operand2: Double): Double {
            return operand1 * operand2
        }
    },
    DIVISION("/") {
        override fun operate(operand1: Double, operand2: Double): Double {
            if (operand2 == 0.0) throw IllegalArgumentException("잘못된 계산식 입니다")
            return operand1 / operand2
        }
    };

    abstract fun operate(operand1: Double, operand2: Double): Double

    companion object {
        fun of(s: String): Operator {
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
