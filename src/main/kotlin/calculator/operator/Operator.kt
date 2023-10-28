package calculator.operator

interface Operator {
    fun operate(left: Double, right: Double): Double
    fun canHandle(operator: String): Boolean
}
