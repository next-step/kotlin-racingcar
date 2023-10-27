package calculator

class BasicOperationsCalculator {
    private fun add(a: Double, b: Double): Double = a + b
    private fun subtract(a: Double, b: Double): Double = a - b
    private fun multiply(a: Double, b: Double): Double = a * b
    private fun divide(a: Double, b: Double): Double = a / b

    fun operation(a: Double, b: Double, symbol: String): Double {
        val operation = Operation.fromSymbol(symbol)

        return when (operation) {
            Operation.ADD -> add(a, b)
            Operation.SUBTRACT -> subtract(a, b)
            Operation.MULTIPLY -> multiply(a, b)
            Operation.DIVIDE -> divide(a, b)
        }
    }
}
