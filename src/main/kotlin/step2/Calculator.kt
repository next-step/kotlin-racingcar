package step2

object Calculator {
    fun calculate(input: String): Double {
        val tokens = input.trim().split(Regex("\\s+"))
        val classifiedTokens = ClassifiedTokenContainer.from(tokens)

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
