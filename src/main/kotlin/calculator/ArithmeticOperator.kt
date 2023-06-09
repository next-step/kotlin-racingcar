package calculator

import kotlin.IllegalArgumentException

enum class ArithmeticOperator(
    val operatorName: String
) {

    PLUS("+") {
        override fun execute(num1: Double, num2: Double): Double {
            return num1 + num2
        }
    },
    MINUS("-") {
        override fun execute(num1: Double, num2: Double): Double {
            return num1 - num2
        }
    },
    MUL("*") {
        override fun execute(num1: Double, num2: Double): Double {
            return num1 * num2
        }
    },
    DIV("/") {
        override fun execute(num1: Double, num2: Double): Double {
            return num1 / num2
        }
    };

    abstract fun execute(num1: Double, num2: Double): Double

    companion object {

        @Throws(IllegalArgumentException::class)
        fun of(operator: String): ArithmeticOperator {
            return values().firstOrNull { it.operatorName == operator }
                ?: throw IllegalArgumentException("input : [$operator], support : ${values().map { it.operatorName }}")
        }
    }
}
