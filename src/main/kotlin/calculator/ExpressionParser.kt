package calculator

object ExpressionParser {

    @Throws(IllegalArgumentException::class)
    fun parse(expression: String): List<String> {
        val tokens = splitExpression(expression)
        val result = arrayListOf<String>()
        var number = ""

        for (token in tokens) {
            when (InputType.of(token)) {
                InputType.NUMBER -> number += token
                InputType.OPERATOR -> {
                    result.add(number)
                    result.add(token)
                    number = ""
                }
                else -> throw IllegalArgumentException("")
            }
        }
        result.add(number)

        return result
    }

    private fun splitExpression(expression: String) = expression.split("").filter { it.isNotBlank() }
}
