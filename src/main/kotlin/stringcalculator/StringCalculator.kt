package stringcalculator

object StringCalculator {
    fun calculate(value: String?): Int {
        require(!value.isNullOrBlank()) { "입력값은 null, 공백일 수 없습니다." }

        val words = value.split(" ")

        var expression: Expression = NumberExpression(words.first())

        for (i in 1 until words.size step 2) {
            val operator = Operator.find(words[i])
            val operand = words[i + 1]

            expression = BinaryExpression(expression, operator, NumberExpression(operand))
        }

        return expression.evaluate().toInt()
    }
}
