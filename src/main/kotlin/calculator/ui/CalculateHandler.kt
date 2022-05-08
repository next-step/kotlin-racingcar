package calculator.ui

import calculator.application.Calculator
import calculator.domain.Expression

class CalculateHandler(
    private val calculator: Calculator = Calculator()
) {
    fun handle(input: String?): Double {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력받은 문자열이 null이거나 공백입니다")
        }
        return calculator.calculate(Expression.of(input))
    }
}
