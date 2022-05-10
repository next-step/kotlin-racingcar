package calculator

object CalculatorProcessor {
    fun calculate(inputStr: String?): Double {
        val expression = InputProcessor.requireNotNullOrBlankInputStr(inputStr)
        val (operators, operands) = InputProcessor.splitInputToPairList(expression)

        var result = operands.first()

        operands.drop(1).zip(operators) { operand, operator ->
            result = operator.expression(result, operand)
        }

        return result
    }
}
