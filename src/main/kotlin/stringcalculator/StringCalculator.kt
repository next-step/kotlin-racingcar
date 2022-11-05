package stringcalculator

object StringCalculator {
    fun calculate(value: String?): Int {
        require(value?.isNotBlank() ?: false) { "입력값은 null, 공백일 수 없습니다." }

        val words = value!!.split(" ")

        var expression: Expression = UnaryExpression(words.first())

        for (i in 1 until words.size step 2) {
            val operator = words[i]
            val second = UnaryExpression(words[i + 1])

            expression = when (operator) {
                "+" -> PlusBinaryExpression(expression, second)
                "-" -> MinusBinaryExpression(expression, second)
                "/" -> DivideBinaryExpression(expression, second)
                "*" -> MultiplyBinaryExpression(expression, second)
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }

        return expression.evaluate().toInt()
    }
}
