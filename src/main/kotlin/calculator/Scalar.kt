package calculator

data class Scalar(override val value: Int) : Operand {
    companion object {
        fun parse(value: String): Scalar {
            return Scalar(value.toInt())
        }
    }
    constructor(operand: Operand) : this(operand.value)
}
