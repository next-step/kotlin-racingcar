package calculator

class Operation(
    private val base: Operand,
    operator: Operator? = null
) {
    var operator: Operator? = operator
        set(value) {
            assertOperatorIsNull()
            field = value
        }

    val result: Scalar
        get() {
            if (operator != null) {
                throw IllegalStateException("The operation is invalid. expression='$base $operator'")
            }
            return Scalar(base)
        }

    fun operate(operand: Operand): Operation {
        val operator = this.operator ?: throw IllegalStateException("The operator does not exist.")
        return Operation(operator.operate(base, operand))
    }

    private fun assertOperatorIsNull() {
        if (operator != null) {
            throw IllegalStateException("The operator already exists.")
        }
    }

    companion object {
        val EMPTY = Operation(Scalar(0), Operator.ADD)
    }
}
