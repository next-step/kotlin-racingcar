package step2.calculator

import java.lang.NumberFormatException

class Calculator(
    private val expression: Expression
) {
    fun calculate(): Int {
        var result = 0
        var operator: Operator = Operator.PLUS

        for (data in expression.generate()) {
            try {
                val value = data.toInt()
                result = operator.operate(result, value)
            } catch (e: NumberFormatException) {
                operator = Operator.findOperator(data)
            }
        }
        return result
    }
}
