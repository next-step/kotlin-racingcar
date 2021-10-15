package calculator

import calculator.domain.SimpleCalculator
import calculator.service.CalculatorService
import calculator.service.SimpleCalculatorService
import calculator.ui.CalculatorView
import calculator.ui.SimpleCalculatorView
import calculator.validator.SimpleExpressionValidator

fun main() = CalculatorApplication(
    calculatorView = SimpleCalculatorView,
    calculatorService = SimpleCalculatorService(
        SimpleCalculator,
        SimpleExpressionValidator
    ),
).run()

class CalculatorApplication(
    private val calculatorView: CalculatorView,
    private val calculatorService: CalculatorService,
) {
    fun run() {
        calculatorView.sayHowToUse()
        val input = calculatorView.input()
        val answer = calculatorService.execute(input)
        calculatorView.sayAnswer(answer.value)
    }
}
