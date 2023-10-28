package calculator.operand

@JvmInline
value class Operand(
    val value: Double
) {
    companion object {
        fun of(value: String): Operand {
            val operand = value.toDoubleOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
            return Operand(operand)
        }
    }
}
