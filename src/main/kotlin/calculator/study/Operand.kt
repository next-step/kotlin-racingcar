package calculator.study

data class Operand(private val value: Int) {

    operator fun plus(other: Operand): Operand = Operand(value + other.value)

    operator fun minus(other: Operand): Operand = Operand(value - other.value)

    operator fun times(other: Operand): Operand = Operand(value * other.value)

    operator fun div(other: Operand): Operand = Operand(value / other.value)

    companion object {
        fun of(value: String): Operand = Operand(value.toInt())
    }
}
