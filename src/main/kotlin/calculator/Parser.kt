package calculator

class Parser(private val tokens: List<Token>) {

    init {
        require(tokens.isNotEmpty()) { "파싱에 사용될 토큰이 존재하지 않습니다." }
    }

    private var position = 0

    fun parse(): Expression {
        return expression().also { validate() }
    }

    private fun expression(): Expression {
        var result = number()

        while (isCurrentType(Token.Type.OPERATOR)) {
            val operator = OperatorFactory.getBinaryFor(pop().literal)
            val right = number()
            result = BinaryExpression(result, operator, right)
        }

        return result
    }

    private fun number(): Expression {
        require(isCurrentType(Token.Type.NUMBER)) { "${peek()}는 실수가 아닙니다." }
        val current = pop()
        return NumberExpression(current.literal)
    }

    private fun pop(): Token = tokens[position++]
    private fun peek(): Token = tokens[position]

    private fun isCurrentType(type: Token.Type): Boolean {
        return tokens.getOrNull(position)?.type == type
    }

    private fun validate() {
        require(position == tokens.size) {
            "문법이 잘못되었습니다. ${peek().literal} 근처를 살펴보세요."
        }
    }
}
