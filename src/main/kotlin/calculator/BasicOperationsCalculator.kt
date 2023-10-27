package calculator

class BasicOperationsCalculator {
    private fun add(a: Double, b: Double): Double = a + b
    private fun subtract(a: Double, b: Double): Double = a - b
    private fun multiply(a: Double, b: Double): Double = a * b
    private fun divide(a: Double, b: Double): Double = a / b

    fun operation(a: Double, b: Double, symbol: String): Double {
        if (symbol == "+") {
            return add(a, b)
        }

        if (symbol == "-") {
            return subtract(a, b)
        }

        if (symbol == "*") {
            return multiply(a, b)
        }

        if (symbol == "/") {
            return divide(a, b)
        }

        throw IllegalArgumentException("Not Valid Form")
    }
}
