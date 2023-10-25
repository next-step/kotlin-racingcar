package step2

class Calculator(private val expr: Expression) {
    constructor(expr: String) : this(Expression(expr))

    fun calculate(): Int {
        val tokens = expr.parse()
        var result = 0
        while (tokens.isNotEmpty()) {
            val token = tokens.poll()
            if (isNumber(token)) {
                result = token.toInt()
            }
            if (!isNumber(token)) {
                result = Operator.getOperator(token).applyAsInt(result, tokens.poll().toInt())
            }
        }
        return result
    }

    private fun isNumber(token: String): Boolean {
        return token.toIntOrNull() != null
    }
}