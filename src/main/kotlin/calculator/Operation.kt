package calculator

class Operation(
    private val operandA: Operand
) {
    private lateinit var operator: Operator

    fun with(operator: Operator): Operation {
        assertOperatorHasNotBeenInitialized()
        this.operator = operator
        return this
    }

    fun calculate(operandB: Operand): Operation {
        return Operation(operator.operate(operandA, operandB))
    }

    val result = Scalar(operandA)

    private fun assertOperatorHasNotBeenInitialized() {
        if (::operator.isInitialized) {
            throw IllegalArgumentException("The operator already exists.")
        }
    }
}
