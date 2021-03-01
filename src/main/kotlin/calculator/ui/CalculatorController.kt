package calculator.ui

import calculator.domain.Expression

class CalculatorController {
    fun run(input: String = "") = Expression(input).getResult()
}
