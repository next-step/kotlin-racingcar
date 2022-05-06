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

    private fun calculateWithExpression(operators: List<Operator>, operands: List<Double>): Double {
        return operands.reduceIndexed {index, acc, i -> operators[index - 1].operate(acc, i) }
    }
}

