package step2

class Calculator {
    fun calculate(expression: String?): Int {
        validateInput(expression)

        val terms = buildTerms(expression!!)

        return calculate(terms)
    }

    private fun validateInput(expression: String?) {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
    }

    private fun buildTerms(expression: String) = expression.split(" ")

    private fun calculate(terms: List<String>): Int {
        var result = terms[0].toInt()

        for (i in 1 until terms.size step 2) {
            val operator = terms[i]
            val operand = terms[i + 1].toInt()

            result = operate(result, operator, operand)
        }
        return result
    }

    private fun operate(result: Int, operator: String, operand: Int) = when (operator) {
        "+" -> result + operand
        "-" -> result - operand
        "*" -> result * operand
        "/" -> result / operand
        else -> throw IllegalArgumentException()
    }
}
