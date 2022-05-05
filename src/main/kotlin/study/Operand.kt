package study

data class Operand constructor(private val value: Int) {

    fun add(other: Operand): Operand = Operand(this.value + other.value)
}
