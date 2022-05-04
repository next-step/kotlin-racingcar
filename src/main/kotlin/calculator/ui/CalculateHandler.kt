package calculator.ui

import calculator.application.Calculator
import calculator.domain.Expression

class CalculateHandler(
    private val calculator: Calculator = Calculator()
) {
    fun handle(input: String?): Double {
        validateInput(input)
        return calculator.calculate(Expression.of(input!!))
    }

    private fun validateInput(input: String?) {
        if (input.isNullOrEmpty() || input.isBlank()) {
            throw IllegalArgumentException("입력받은 문자열이 null이거나 공백입니다")
        }
    }
}