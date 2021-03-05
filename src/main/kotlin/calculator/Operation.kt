package calculator

class Operation(
    private val base: Operand
) {
    constructor(base: Operand, operator: Operator) : this(base) {
        this.operator = operator
    }

    val result: Scalar
        get() {
            if (operator != null) {
                throw IllegalArgumentException("The operation is invalid")
            }
            return Scalar(base)
        }

    var operator: Operator? = null
        set(value) {
            assertOperatorIsNull()
            field = value
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
