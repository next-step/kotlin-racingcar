package calculator

class Operation(
    private val base: Operand
) {
    companion object {
        val Empty = Operation(Scalar(0)).with(AddOperator)
    }

    private var operator: Operator? = null

    fun with(operator: Operator): Operation {
        assertOperatorIsNull()
        this.operator = operator
        return this
    }

    fun with(operand: Operand): Operation {
        val operator = this.operator.orThrow()
        return Operation(operator.operate(base, operand))
    }

    val result: Scalar get() {
        if (operator != null) {
            throw IllegalArgumentException("The operation is invalid")
        }
        return Scalar(base)
    }

    private fun Operator?.orThrow(): Operator {
        if (this == null) {
            throw IllegalArgumentException("The operator does not exist.")
        }
        return this
    }

    private fun assertOperatorIsNull() {
        if (operator != null) {
            throw IllegalArgumentException("The operator already exists.")
        }
    }
}
