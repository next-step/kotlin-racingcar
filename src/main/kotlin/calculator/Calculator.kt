package calculator

class Calculator {
    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    private fun divide(a: Int, b: Int): Int {
        return a / b
    }

    fun calculate(a: Int, op: String, b: Int): Int {
        return when (op) {
            "+" -> add(a, b)
            "-" -> subtract(a, b)
            "*" -> multiply(a, b)
            "/" -> divide(a, b)
            else -> throw IllegalArgumentException("Invalid operator : $op")
        }
    }
}
