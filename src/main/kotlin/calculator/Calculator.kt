package calculator

interface Calculator {
    fun calculate(): Double
}

class StringCalculator(
    private val expression: ArithmeticExpression
) : Calculator {

    override fun calculate(): Double {
        val operators = expression.operators
        val operands = expression.operands

        return calculateWithExpression(operators, operands)
    }

    private fun calculateWithExpression(operators: List<String>, operands: List<Int>): Double {
        return operands.reduceIndexed {index, acc, i ->
            when (operators[index - 1]) {
                "+" -> acc + i
                "-" -> acc - i
                "*" -> acc * i
                "/" -> acc / i
                else -> throw IllegalArgumentException("사칙연산 기호가 아닌경우 연산을 진행할 수 없습니다.")
            }
        }.toDouble()
    }
}

