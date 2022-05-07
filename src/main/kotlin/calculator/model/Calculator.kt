package calculator.model

object Calculator {
    fun calculate(expression: String): Int {
        validateExpression(expression)

        val split = expression.split(" ")
        var result = split[0].toInt()

        for (i in 1 until split.size step (2)) {
            val symbol = split[i].first()
            val num = split[i + 1].toInt()
            result = Operator.calculate(result, num, symbol)
        }

        return result
    }

    private fun validateExpression(expression: String) {
        require(expression.isNotBlank()) { "수식은 공백이 될 수 없습니다." }
    }
}
