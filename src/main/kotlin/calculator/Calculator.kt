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

    private fun calculate(a: Int, op: String, b: Int): Int {
        return when (op) {
            "+" -> add(a, b)
            "-" -> subtract(a, b)
            "*" -> multiply(a, b)
            "/" -> divide(a, b)
            else -> throw IllegalArgumentException("Invalid operator : $op")
        }
    }

    fun run(formula: String?): Int {
        val trimmed = formula?.trim()
        if (trimmed.isNullOrEmpty()) throw IllegalArgumentException("Formula should not be null or empty")

        val tokens = trimmed.split(" ")
        var result = tokens.first().toInt()
        for (i in 1 until tokens.size step 2) {
            result = calculate(a = result, op = tokens[i], b = tokens[i + 1].toInt())
        }

        return result
    }
}
