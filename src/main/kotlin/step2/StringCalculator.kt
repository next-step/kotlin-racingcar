package step2

import step2.CalculatorValidator.isNumber
import step2.CalculatorValidator.isOperator
import step2.CalculatorValidator.validateIsNumberOrOperator
import step2.CalculatorValidator.validateRegex
import step2.Operator.Companion.getOperator

class StringCalculator {

    fun execute(formula: String): Double {
        require(formula.isNotEmpty() && formula.isNotBlank())
        validateRegex(formula)

        val values = formula.split(" ")
        var result = values[0].toDouble()
        lateinit var operator: Operator

        for (i in 1 until values.size) {
            val value = values[i]
            validateIsNumberOrOperator(value)

            if (isOperator(value)) {
                operator = getOperator(value)
            }
            if (isNumber(value)) {
                result = Operator.calculate(prev = result, next = value.toDouble(), operator = operator)
            }
        }

        return result
    }
}
