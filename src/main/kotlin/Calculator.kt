fun String.containsInvalidSymbols(): Boolean {
    return this.any { !it.isDigit() && it !in Operator.getValidSymbols() && it != ' ' }
}

private const val EXPRESSION_REGEX = "\\s+"

class Calculator {

    fun compute(input: String): Int {
        validate(input)
        val tokens = tokenize(input)

        return calculate(tokens)
    }

    private fun validate(input: String) {
        require(input.isNotBlank()) { "Input should not be blank" }
        require(!input.containsInvalidSymbols()) { "Input contains invalid symbols" }
    }

    private fun tokenize(input: String): List<String> {
        val tokens = input.trim().split(EXPRESSION_REGEX.toRegex())
        require(tokens.size >= 3) { "Expression is too short to compute" }

        return tokens
    }

    private fun calculate(tokens: List<String>): Int {
        var result = tokens[0].toIntOrNull() ?: throw IllegalArgumentException("Invalid number: ${tokens[0]}")
        var i = 1

        while (i < tokens.size) {
            val operatorToken = tokens[i]

            val operator = Operator.from(operatorToken)
            val operand = getOperand(tokens, i, operatorToken)

            result = operator.apply(result, operand)
            i += 2
        }

        return result
    }

    private fun getOperand(
        tokens: List<String>,
        index: Int,
        operatorToken: String
    ): Int {
        val operandToken = (tokens.getOrNull(index + 1)
            ?: throw IllegalArgumentException("Missing operand after operator '$operatorToken'"))

        return operandToken.toInt()
    }
}