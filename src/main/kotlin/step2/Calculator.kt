package step2

class Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        val terms = expression.split(" ")

        var result = terms[0].toInt()

        for (i in 1 until terms.size step 2) {
            val operator = terms[i]
            val operand = terms[i + 1].toInt()

            result = when (operator) {
                "+" -> result + operand
                "-" -> result - operand
                "*" -> result * operand
                "/" -> result / operand
                else -> throw IllegalArgumentException()
            }
        }

        return result
    }
}