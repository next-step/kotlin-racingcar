package step2

class Parser {
    companion object {
        private val space = "\\s".toRegex()
    }

    fun parse(rawExpression: String): List<Pair<Operator, Double>> {
        if (rawExpression.isEmpty()) {
            throw IllegalArgumentException("입력값이 빈 값이면 예외가 발생합니다.")
        }

        val tokenizedExpressions: List<String> = rawExpression.split(space)

        if (tokenizedExpressions.size > 3 && tokenizedExpressions.size % 2 == 0) {
            throw IllegalArgumentException("짝수개의 피연산자와 홀수개의 연산자가 존재 해야 합니다.")
        }

        val isValid: Boolean = tokenizedExpressions
            .mapIndexed { index, expression -> index to expression }
            .all { (index, expression) ->
                this.valid(index, expression)
            }

        if (!isValid) {
            throw IllegalArgumentException("올바르지 않는 (피)연산자 수식 입니다.")
        }

        return listOf(Operator.PLUS.symbol)
            .plus(tokenizedExpressions)
            .chunked(2)
            .map { (symbol, operand) ->
                Operator.of(symbol) to operand.toDouble()
            }
    }

    private fun valid(index: Int, expression: String): Boolean =
        if (index % 2 == 0) {
            expression.toDoubleOrNull()?.let { true } ?: false
        } else {
            Operator.exist(expression)
        }
}
