package calculator

class Operation(
    private val operandA: Operand
) {
    private lateinit var operator: Operator

    fun with(operator: Operator): Operation {
        this.operator = operator
        return this
    }

    fun calculate(operandB: Operand): Scalar {
        return operator.operate(operandA, operandB)
    }
}
