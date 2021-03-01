package calculator

class Operation(
    private val operandA: Operand
) {
    companion object {
        val Empty = Operation(Scalar(0)).with(AddOperator)
    }

    private lateinit var operator: Operator

    fun with(operator: Operator): Operation {
        assertOperatorHasNotBeenInitialized()
        this.operator = operator
        return this
    }

    fun with(operandB: Operand): Operation {
        return Operation(operator.operate(operandA, operandB))
    }

    val result = Scalar(operandA)

    private fun assertOperatorHasNotBeenInitialized() {
        if (::operator.isInitialized) {
            throw IllegalArgumentException("The operator already exists.")
        }
    }
}
