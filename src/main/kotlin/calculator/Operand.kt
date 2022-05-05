package calculator

@JvmInline
value class Operand(val value: Double) {
    companion object {
        fun of(value: String): Operand {
            return kotlin.runCatching {
                Operand(value.toDouble())
            }.getOrElse { throw IllegalArgumentException() }
        }
    }
}
