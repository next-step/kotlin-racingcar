package step2

import java.util.function.BinaryOperator
import java.util.function.DoubleBinaryOperator

enum class Operator(val symbol: String) : BinaryOperator<Double>, DoubleBinaryOperator {

    PLUS("+") {
        override fun apply(t: Double, u: Double): Double = t + u
    }, MINUS("-") {
        override fun apply(t: Double, u: Double): Double = t - u
    }, TIMES("*") {
        override fun apply(t: Double, u: Double): Double = t * u
    }, DEVIDE("/") {
        override fun apply(t: Double, u: Double): Double {
            require(u > 0) {
                "Divide by zero: divider = $u"
            }
            return t / u
        }
    };

    override fun applyAsDouble(t: Double, u: Double): Double = apply(t, u)
}
