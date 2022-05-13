package step2

import java.util.function.BinaryOperator
import java.util.function.DoubleBinaryOperator

enum class Operator(val symbol: String) : BinaryOperator<Double>, DoubleBinaryOperator {

    PLUS("+") {
        override fun apply(t: Double, u: Double): Double = t + u
    },
    MINUS("-") {
        override fun apply(t: Double, u: Double): Double = t - u
    },
    TIMES("*") {
        override fun apply(t: Double, u: Double): Double = t * u
    },
    DEVIDE("/") {
        override fun apply(t: Double, u: Double): Double {
            require(u > 0) {
                "Divide by zero: divider = $u"
            }
            return t / u
        }
    };

    companion object {
        fun find(targetSymbol: String): Operator {
            return Operator.values()
                .find { op ->
                    op.symbol == targetSymbol
                } ?: run {
                throw IllegalArgumentException("$targetSymbol is non-arithmetic symbol")
            }
        }
    }

    override fun applyAsDouble(t: Double, u: Double): Double = apply(t, u)
}
