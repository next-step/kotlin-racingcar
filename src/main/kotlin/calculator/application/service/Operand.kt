package calculator.application.service

@JvmInline
value class Operand(
    val value: Int,
) {
    operator fun plus(other: Operand): Operand = Operand(this.value + other.value)
    operator fun minus(other: Operand): Operand = Operand(this.value - other.value)
    operator fun times(other: Operand): Operand = Operand(this.value * other.value)
    operator fun div(other: Operand): Operand = Operand(this.value / other.value)

    companion object {
        val ZERO = Operand(value = 0)

        fun fromString(value: String): Operand = Operand(value.toInt())
    }
}
