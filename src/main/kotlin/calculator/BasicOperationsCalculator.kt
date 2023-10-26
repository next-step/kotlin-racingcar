package calculator

class BasicOperationsCalculator {
    fun add(a: Double, b: Double): Double = a + b
    fun subtract(a: Double, b: Double): Double = a - b
    fun multiply(a: Double, b: Double): Double = a * b
    fun divide(a: Double, b: Double): Double = a / b

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
