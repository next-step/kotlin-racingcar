package calculator

class Expression(
    private val prevNumber: Double,
    private val operator: Operator,
    private val nextNumber: Double
) {
    init {
        validateDivisionAvailability(operator, nextNumber)
    }

    private fun validateDivisionAvailability(
        operator: Operator,
        nextNumber: Double
    ) {
        when (operator) {
            Operator.DIVISION -> nextNumber.takeIf { nextNumber > 0 }
                ?: throw IllegalArgumentException("It cannot be divided by zero.")
            else -> println("Computable formula.")
        }
    }
}
