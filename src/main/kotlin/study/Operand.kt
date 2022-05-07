package study

data class Operand constructor(private val value: Int) {

    operator fun plus(other: Operand): Operand = Operand(this.value + other.value)

    operator fun minus(other: Operand): Operand = Operand(this.value - other.value)

    operator fun times(other: Operand): Operand = Operand(this.value * other.value)

    operator fun div(other: Operand): Operand = Operand(this.value / other.value)

    companion object {
        fun of(value: String): Operand = Operand(value.toInt())
    }
}
