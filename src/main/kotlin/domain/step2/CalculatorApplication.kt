package domain.step2

import domain.step2.domain.Calculator
import domain.step2.domain.expression.Expression
import global.strategy.input.ConsoleInputStrategy
import global.strategy.output.ConsoleOutputStrategy
import domain.step2.strategy.split.SingleBlankSplitStrategy
import domain.step2.ui.CalculatorInputView
import domain.step2.ui.CalculatorOutputView

class CalculatorApplication(private val inputView: CalculatorInputView, private val outputView: CalculatorOutputView) {
    tailrec fun run() {
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
