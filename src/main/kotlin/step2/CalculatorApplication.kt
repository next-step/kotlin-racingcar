package step2

import step2.domain.Calculator
import step2.domain.expression.Expression
import step2.strategy.input.ConsoleInputStrategy
import step2.strategy.output.ConsoleOutputStrategy
import step2.strategy.split.SingleBlankSplitStrategy
import step2.ui.CalculatorInputView
import step2.ui.CalculatorOutputView

class CalculatorApplication(private val inputView: CalculatorInputView, private val outputView: CalculatorOutputView) {
    fun run() {
        try {
            val lawExpression = inputView.inputExpression() ?: throw IllegalArgumentException(NULL_EXCEPTION_MESSAGE)
            val expression = Expression(lawExpression)
            val operand = Calculator.calculate(expression, SingleBlankSplitStrategy())
            val result = operand.operand
            outputView.outputResult(result.toString())
        } catch (e: Exception) {
            println(e.message)
            run()
        }
    }

    companion object {
        const val NULL_EXCEPTION_MESSAGE = "널 값은 들어올 수 없습니다."
    }
}

fun main() {
    val calculatorInputView = CalculatorInputView(ConsoleInputStrategy())
    val calculatorOutputView = CalculatorOutputView(ConsoleOutputStrategy())
    CalculatorApplication(calculatorInputView, calculatorOutputView).run()
}
