package calculator

class Parser(private val tokens: List<Token>) {

    private var position = 0

    fun parse(): Expression {
        return expression()
    }

    private fun expression(): Expression {
        var result = number()

        while (currentIsOperator()) {
            val operator = OperatorFactory.getBinaryFor(pop().literal)
            val right = number()
            result = BinaryExpression(result, operator, right)
        }

        return result
    }

    private fun number(): Expression {
        val current = peek()
        if (current.type == Token.Type.NUMBER) {
            position++
            return NumberExpression(current.literal)
        }

        throw IllegalArgumentException()
    }

    private fun pop(): Token = tokens[position++]
    private fun peek(): Token = tokens[position]

    private fun currentIsOperator(): Boolean {
        return tokens.getOrNull(position)?.type == Token.Type.OPERATOR
    }
}
