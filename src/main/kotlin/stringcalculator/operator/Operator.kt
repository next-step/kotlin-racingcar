package stringcalculator.operator

interface Operator {
    fun character(): String

    fun operate(x: Double, y: Double): Double
}
