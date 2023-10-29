package calculator

class Operand(
    val value: Int,
) {
    companion object {
        fun of(value: String): Operand {
            return Operand(value.toInt())
        }
    }
}
