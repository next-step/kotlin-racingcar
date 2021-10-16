package calculator

object Calculator {

    fun evaluate(expression: String): Double {
        val tokens = getTokens(expression)
        return Parser(tokens).parse().evaluate()
    }
}
