package step2

import java.util.function.BinaryOperator
import java.util.function.DoubleBinaryOperator

enum class Operator(val symbol: String): BinaryOperator<Double>, DoubleBinaryOperator {

    PLUS("+") {
        override fun apply(t: Double, u: Double): Double = t + u
    }, MINUS("-") {
        override fun apply(t: Double, u: Double): Double = t - u
    }, TIMES("*") {
        override fun apply(t: Double, u: Double): Double = t * u
    }, DEVIDE("/") {
        override fun apply(t: Double, u: Double): Double {
            require(u > 0) {
                "제수 u는 0보다 커야 합니다. u = $u"
            }
            return t / u
        }
    };

    override fun applyAsDouble(t:Double, u: Double): Double = apply(t, u)


}