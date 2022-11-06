package calculator

import calculator.const.CalculatorException
import kotlin.IllegalArgumentException

enum class Operator(val op: String) : (Double, Double) -> Double {
    ADD("+") {
        override fun invoke(a: Double, b: Double): Double = a.plus(b)
    },
    MINUS("-") {
        override fun invoke(a: Double, b: Double): Double = a.minus(b)
    },
    DIVIDE("/") {
        override fun invoke(a: Double, b: Double): Double {
            require(b != 0.0) { CalculatorException.ZERO_DIVIDE_ERROR }
            return a.div(b)
        }
    },
    MULTIPLY("*") {
        override fun invoke(a: Double, b: Double): Double = a.times(b)
    };

    companion object {
        fun from(op: String) = Operator.values().find { it.op == op } ?: throw IllegalArgumentException(CalculatorException.NOT_PROPER_OPERATOR)
        fun exist(op: String) = Operator.values().any { it.op == op }
    }
}
