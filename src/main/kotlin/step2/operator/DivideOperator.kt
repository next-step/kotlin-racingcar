package step2.operator

import kotlin.math.roundToInt

class DivideOperator : Operator {
    override fun operate(x: Double, y: Double): Double {
        return round(x / y)
    }

    private fun round(number: Double): Double {
        return (number * 100).roundToInt() / 100.0
    }
}