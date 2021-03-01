package calculator

data class Scalar(override val value: Int) : Operand {
    constructor(operand: Operand) : this(operand.value)
}
