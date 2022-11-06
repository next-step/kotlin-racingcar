package stringcalculator.operator

import kotlin.math.roundToInt

enum class Operator(
    val character: String
) {
    PLUS("+") {
        override fun operate(x: Double, y: Double): Double {
            return x + y
        }
    },
    MINUS("-") {
        override fun operate(x: Double, y: Double): Double {
            return x - y
        }
    },
    MULTIPLY("*") {
        override fun operate(x: Double, y: Double): Double {
            return x * y
        }
    },
    DIVIDE("/") {
        override fun operate(x: Double, y: Double): Double {
            return round(x / y)
        }

        private fun round(number: Double): Double {
            return (number * 100).roundToInt() / 100.0
        }
    };

    abstract fun operate(x: Double, y: Double): Double
}
