package calculator.application

import calculator.domain.Expression

class Calculator {

    fun calculate(expression: Expression): Double {
        val result = expression.run {
            operators.foldIndexed(operands[0]) { i, result, operator ->
                operator.operation(result, operands[i + 1])
            }
        }
        return result.value
    }
}
