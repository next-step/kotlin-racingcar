package next.step.calculator.domain

import next.step.calculator.domain.exception.NotEnoughExpressionCountException

class Expressions(private val expressions: List<String>) {
    companion object {
        fun of(expressions: List<String>): Expressions {
            if (isNotEnoughCount(expressions)) {
                throw NotEnoughExpressionCountException()
            }
            return Expressions(expressions)
        }

        private fun isNotEnoughCount(expressions: List<String>) = expressions.size % 2 == 0
    }

    fun evaluate(): Int {
        var result = InputNumber(0)
        var operator = Operator.PLUS
        for ((index, expression) in expressions.withIndex()) {
            if (isNumber(index)) {
                result = operator.evaluate(result, InputNumber.from(expression))
                continue
            }
            operator = Operator.from(expression)
        }
        return result.toInt()
    }

    private fun isNumber(index: Int) = index % 2 == 0
}
