package calculator.operand

@JvmInline
value class Operand(
    private val value: Double
) {
    operator fun div(right: Operand): Operand {
        return of(value / right.value)
    }

    operator fun minus(right: Operand): Operand {
        return of(value - right.value)
    }

    operator fun times(right: Operand): Operand {
        return of(value * right.value)
    }

    operator fun plus(right: Operand): Operand {
        return of(value + right.value)
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {

        fun of(value: String): Operand {
            val operand = value.toDoubleOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다. 현재 입력값: $value")
            return Operand(operand)
        }

        fun of(value: Double): Operand {
            return Operand(value)
        }
    }
}
