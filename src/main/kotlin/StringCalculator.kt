import Operator.Companion.getOperator
import Operator.Companion.isOperator
import java.lang.NumberFormatException

class StringCalculator {

    fun execute(formula: String): Double {
        require(formula.isNotEmpty() && formula.isNotBlank())

        val values = formula.split(" ")
        validateNumber(values[0])
        var result = values[0].toDouble()
        lateinit var operator: Operator

        for (i in 1 until values.size) {
            val value = values[i]
            validate(value)

            if (isOperator(value)) {
                operator = getOperator(value)
            }
            if (isNumber(value)) {
                result = calculate(prev = result, next = value.toDouble(), operator = operator)
            }
        }

        return result
    }

    private fun calculate(prev: Double, next: Double, operator: Operator): Double {
        return when (operator) {
            Operator.PLUS -> prev + next
            Operator.MINUS -> prev - next
            Operator.MULTIPLY -> prev * next
            Operator.DIVIDE -> prev / next
        }
    }

    private fun validateNumber(value: String) {
        if (!isNumber(value)) {
            throw IllegalArgumentException("올바른 계산식이 아닙니다.")
        }
    }

    private fun validate(value: String) {
        if (!isNumber(value) && !isOperator(value)) {
            throw IllegalArgumentException("올바른 계산식이 아닙니다.")
        }
    }

    private fun isNumber(value: String): Boolean {
        try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }
}
