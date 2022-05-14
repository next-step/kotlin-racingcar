package calculator

interface Calculator {
    fun calculate(): Double
}

class StringCalculator(
    private val expression: ArithmeticExpression
) : Calculator {

    override fun calculate(): Double {
        return with(expression) {
            operands.reduceIndexed { index, acc, i -> operators[index - 1].operate(acc, i) }
        }
    }
}
