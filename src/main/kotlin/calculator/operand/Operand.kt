package calculator.operand

@JvmInline
value class Operand(
    private val value: Double
) {
    operator fun div(right: Operand): Double {
        return value / right.value
    }

    operator fun minus(right: Operand): Double {
        return value - right.value
    }

    operator fun times(right: Operand): Double {
        return value * right.value
    }

    operator fun plus(right: Operand): Double {
        return value + right.value
    }

    companion object {
        fun of(value: String): Operand {
            val operand = value.toDoubleOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
            return Operand(operand)
        }
    }
}
