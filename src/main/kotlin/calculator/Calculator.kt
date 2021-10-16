package calculator

object Calculator {

    private val operatorRegex = Regex("(?<=[+\\-*/])|(?=[+\\-*/])")

    fun evaluate(expression: String): Double {
        val tokens = expression.filter { !it.isWhitespace() }
            .split(operatorRegex)

        return evaluate(tokens)
    }

    private fun evaluate(tokens: List<String>): Double {
        if (tokens.size == 1) {
            return tokens[0].toDoubleOrNull() ?: throw IllegalArgumentException()
        }

        val left = tokens[0].toDoubleOrNull() ?: throw IllegalArgumentException()
        val right = tokens[2].toDoubleOrNull() ?: throw IllegalArgumentException()
        val result = evaluate(left, tokens[1], right)
        val newTokens = listOf(result.toString()).plus(tokens.subList(3, tokens.size))
        return evaluate(newTokens)
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
