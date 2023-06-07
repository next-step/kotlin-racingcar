package next.step.calculator.domain

class Expressions(private val expressions: List<String>) {
    companion object {
        fun of(expressions: List<String>): Expressions {
            require(isEnoughCount(expressions)) { "expression 들은 홀수 개여야 합니다." }
            return Expressions(expressions)
        }

        private fun isEnoughCount(expressions: List<String>) = expressions.size % 2 == 1
    }

    fun evaluate(): Int {
        var result = InputNumber(0)
        var operator = Operator.PLUS
        for ((index, expression) in expressions.withIndex()) {
            if (isNumberIndex(index)) {
                result = operator.evaluate(result, InputNumber.from(expression))
                continue
            }
            operator = Operator.from(expression)
        }
        return result.toInt()
    }

    private fun isNumberIndex(index: Int) = index % 2 == 0
}
