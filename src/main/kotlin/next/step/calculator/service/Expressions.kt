package next.step.calculator.service

import next.step.calculator.domain.InputNumber
import next.step.calculator.domain.Operator

object Expressions {
    fun evaluate(expressions: List<String>): Int {
        require(isEnoughCount(expressions)) { "expression 들은 홀수 개여야 합니다." }

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

    private fun isEnoughCount(expressions: List<String>) = expressions.size % 2 == 1
    private fun isNumberIndex(index: Int) = index % 2 == 0
}
