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

        return operators
            .zip(operands.drop(1))
            .fold(operands.first()) { prev, (operator, next) ->
                operator.operate(prev, next)
            }
    }
}
