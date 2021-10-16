package calculator

object Calculator {

    private val operatorRegex = Regex("(?<=[+\\-*/])|(?=[+\\-*/])")

    fun evaluate(expression: String): Double {
        val tokens = expression.filter { !it.isWhitespace() }
            .split(operatorRegex)

        var result = tokens[0].toDoubleOrNull() ?: throw IllegalArgumentException()

        for (i in tokens.indices) {
            if (i % 2 == 0) {
                continue
            }
            val right = tokens[i + 1].toDoubleOrNull() ?: throw IllegalArgumentException()
            result = evaluate(result, tokens[i], right)
        }

        return result
    }

    private fun evaluate(left: Double, operator: String, right: Double): Double {
        return when (operator) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            "/" -> left / right
            else -> throw IllegalArgumentException()
        }
    }
}
