package calculator.calculator.ui

import calculator.calculator.domain.Expression

class CalculatorController {
    fun run(input: String = "") = Expression(input).getResult()
}
