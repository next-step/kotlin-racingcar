package calculator

class BasicOperationsCalculator {
    private fun add(a: Double, b: Double): Double = a + b
    private fun subtract(a: Double, b: Double): Double = a - b
    private fun multiply(a: Double, b: Double): Double = a * b
    private fun divide(a: Double, b: Double): Double = a / b

    fun operation(a: Double, b: Double, symbol: String): Double {
        val operator = Operator.fromSymbol(symbol)
        return operator.operate(a, b)
    }
}
