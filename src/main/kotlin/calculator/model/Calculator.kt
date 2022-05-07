package calculator.model

import java.util.function.BinaryOperator

enum class Calculator(
    val symbol: String,
    val operator: BinaryOperator<Int>
) {

    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLICATION("*", { num1, num2 -> num1 * num2 }),
    DIVISION("/", { num1, num2 ->
        if (num2 == 0) {
            throw IllegalArgumentException("나누는 수가 0이 될 수 없습니다.")
        }
        num1 / num2
    });

    companion object {
        fun calculate(expression: String): Int {
            validateExpression(expression)

            val split = expression.split(" ")
            var result = split[0].toInt()

            for (i in 1 until split.size step (2)) {
                val symbol = split[i]
                val num = split[i + 1].toInt()
                result = Calculator.calculate(result, num, symbol)
            }

            return result
        }

        private fun validateExpression(expression: String) {
            if (expression.isBlank()) {
                throw IllegalArgumentException("수식은 공백이 될 수 없습니다.")
            }
        }

        private fun calculate(num1: Int, num2: Int, symbol: String): Int {
            val operator = findOperator(symbol)
            return operator.operator.apply(num1, num2)
        }

        private fun findOperator(symbol: String): Calculator {
            return Calculator.values()
                .find { it.symbol == symbol }
                ?: throw IllegalArgumentException("존재하지 않는 수식 기호입니다. (symbol: $symbol)")
        }
    }
}
