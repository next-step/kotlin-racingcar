package calculator

class Operation(
    private val base: Operand,
    operator: Operator? = null
) {
    var operator: Operator? = operator
        set(value) {
            check(operator == null) {
                "The operator already exists."
            }
            field = value
        }

    val result: Scalar
        get() {
            check(operator == null) {
                "The operation is invalid. expression='$base $operator'"
            }
            return Scalar(base)
        }

    fun operate(operand: Operand): Operation {
        val operator = this.operator ?: throw IllegalStateException("The operator does not exist.")
        return Operation(operator.operate(base, operand))
    }

    companion object {
        val EMPTY = Operation(Scalar(0), Operator.ADD)
    }
}
