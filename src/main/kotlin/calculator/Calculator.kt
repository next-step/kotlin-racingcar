package calculator

class Calculator {
    fun calculate(formula: String): Int {
        val elements = formula.split(" ")

        var result = elements[0].toInt()

        for (i in 1 until elements.size step 2) {
            val operator = elements[i]
            val operand = elements[i + 1].toInt()

            result = when (operator) {
                "+" -> result + operand
                "-" -> result - operand
                "*" -> result * operand
                "/" -> result / operand
                else -> throw IllegalArgumentException("Unknown operator: $operator")
            }
        }

        return result
    }
}
