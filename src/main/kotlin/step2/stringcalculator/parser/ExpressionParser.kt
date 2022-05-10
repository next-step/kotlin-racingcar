package step2.stringcalculator.parser

object ExpressionParser {

    fun parse(expression: String?): List<Token> {
        val argumentList = expression?.split(" ")
            ?.filter { it.isNotBlank() }
            ?.map { it.toToken() }

        if (argumentList.isNullOrEmpty()) {
            throw IllegalArgumentException("Expression is null or empty string")
        }
        return argumentList
    }

    private fun String.isDouble() = try {
        this.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }

    private fun String.toToken(): Token {
        return when (val valueString = this.trim()) {
            "+" -> TokenOperatorPlus()
            "-" -> TokenOperatorMinus()
            "*" -> TokenOperatorMultiply()
            "/" -> TokenOperatorDivide()
            else -> if (valueString.isDouble()) TokenNumber(valueString) else TokenInvalid(valueString)
        }
    }
}
