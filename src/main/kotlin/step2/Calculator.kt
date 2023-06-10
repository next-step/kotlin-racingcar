package step2

object Calculator {
    fun calculate(input: String): Double {
        val classifiedTokens = ClassifiedTokenContainer.from(input)

        return calculate(classifiedTokens)
    }

    private fun calculate(tokenContainer: ClassifiedTokenContainer): Double {
        val tokens = tokenContainer.tokens()
        val operands = tokens.operands
        val operators = tokens.operators

        val firstOperand = operands[0]
        return operators
            .zip(operands.subList(1, operands.size))
            .fold(firstOperand) { prev, (operator, next) ->
                operator.operate(prev, next)
            }
    }
}
