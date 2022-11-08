package stringcalculator

object StringCalculator {
    fun calculate(value: String?): Int {
        require(value?.isNotBlank() ?: false) { "입력값은 null, 공백일 수 없습니다." }

        val words = value!!.split(" ")

        var expression: Expression = UnaryExpression(words.first())

        for (i in 1 until words.size step 2) {
            val operator = Operator.find(words[i])
            val operand = words[i + 1]

            expression = BinaryExpression(expression, operator, UnaryExpression(operand))
        }

        return expression.evaluate().toInt()
    }
}
