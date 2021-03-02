package calculator

interface Operator {
    val value: String

    fun operate(a: Operand, b: Operand): Scalar

    companion object {
        fun parse(value: String): Operator {
            return when (value) {
                AddOperator.value -> AddOperator
                SubtractOperator.value -> SubtractOperator
                MultiplyOperator.value -> MultiplyOperator
                DivideOperator.value -> DivideOperator
                else -> throw IllegalArgumentException("The value is not operator, value='$value'")
            }
        }
    }
}
