package step2

@JvmInline
value class Operand private constructor(val value: Int) {
    companion object {
        fun of(operand: String): Operand = operand.toIntOrNull()?.let {
            Operand(it)
        } ?: throw IllegalArgumentException("invalid operand")
    }
}
