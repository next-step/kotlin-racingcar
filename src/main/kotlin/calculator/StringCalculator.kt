package calculator

import java.util.Queue

object StringCalculator {

    fun calculate(input: String?): Long {
        val parsedInput: Queue<String> = ArithmeticExpressionParser.parse(input)

        var result = ArithmeticOperand.of(parsedInput.poll())

        while (parsedInput.isNotEmpty()) {
            val operator = ArithmeticOperator.of(parsedInput.poll())
            val operand = ArithmeticOperand.of(parsedInput.poll())

            result = operator.operate(result, operand)
        }

        return result.value
    }
}
