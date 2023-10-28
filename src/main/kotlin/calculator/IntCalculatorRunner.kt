package calculator

import java.lang.IllegalArgumentException

object IntCalculatorRunner {
    fun run() {
        val input = Scanner.scanInput() ?: throw IllegalArgumentException("올바른 입력 값이 아닙니다")
        val expression = IntExpression.of(input)
        val result = IntCalculator.calculate(expression)
        Printer.printInt(result)
    }
}
