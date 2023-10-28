package calculator

import java.util.Queue

object StringCalculator {

    fun calculate(input: String?): Long {
        val parsedInput: Queue<String> = ArithmeticExpressionParser.parse(input)

        var result = parsedInput.poll().toLong()
        while (parsedInput.isNotEmpty()) {
            val operator = ArithmeticOperator.of(parsedInput.poll())
            val operand = parsedInput.poll().toLong()
            result = operator.operate(result, operand)
        }

        return result
    }
}
