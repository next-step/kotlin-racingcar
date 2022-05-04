package calculator.application

import calculator.domain.Expression

class Calculator {

    fun calculate(expression: Expression): Double {
        expression.run {
            var result = operands[0]
            for (i in 1 until operands.size) {
                result = operators[i - 1].operation(result, operands[i])
            }
            return result.value
        }
    }
}
