package step2.calculator

class Expression(
    private val prev: Double,
    private val operator: Operator,
    private val next: Double
) {
    fun calculate(): Double {
        validateExpressionAvailability(prev, operator, next)

        return operator.calculate(prev, next)
    }

    private fun validateExpressionAvailability(
        @Suppress("UNUSED_PARAMETER") prev: Double,
        operator: Operator,
        next: Double
    ) {
        when (operator) {
            Operator.DIVISION -> next.takeIf { next > 0 }
                ?: throw IllegalArgumentException("It cannot be divided by zero.")
            else -> println("Computable formula.")
        }
    }
}
