package calculator

class Operation(
    private val base: Operand
) {
    val result: Scalar
        get() {
            if (operator != null) {
                throw IllegalArgumentException("The operation is invalid")
            }
            return Scalar(base)
        }

    private var operator: Operator? = null

    fun with(operator: Operator): Operation {
        assertOperatorIsNull()
        this.operator = operator
        return this
    }

    fun with(operand: Operand): Operation {
        val operator = this.operator ?: throw IllegalStateException("The operator does not exist.")
        return Operation(operator.operate(base, operand))
    }

    private fun assertOperatorIsNull() {
        if (operator != null) {
            throw IllegalStateException("The operator already exists.")
        }
    }

    companion object {
        val EMPTY = Operation(Scalar(0)).with(AddOperator)
    }
}
