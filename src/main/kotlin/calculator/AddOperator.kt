package calculator

object AddOperator : Operator {
    override val value = "+"

    override fun operate(a: Operand, b: Operand): Scalar {
        return Scalar(a.value + b.value)
    }
}
