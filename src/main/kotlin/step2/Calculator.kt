package step2

object Calculator {
    fun calculate(input: String): Double {
        val classifiedTokens = ClassifiedTokenContainer.from(input)

        val calculated = calculate(classifiedTokens)

        return calculated.double
    }

    private fun calculate(tokenContainer: ClassifiedTokenContainer): Operand {
        val iterators = tokenContainer.tokens()
        val operands = iterators.operands
        val operators = iterators.operators

        var calculated = operands.next()
        operators.forEach {
            val nextOperand = operands.next()
            calculated = it.operate(calculated, nextOperand)
        }
        return calculated
    }
}
