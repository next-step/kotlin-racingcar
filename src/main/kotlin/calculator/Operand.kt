package calculator

data class Operand(val value: Long) {
    operator fun plus(other: Operand): Operand { return Operand(this.value.plus(other.value)) }

    operator fun minus(other: Operand): Operand { return Operand(this.value.minus(other.value)) }

    operator fun times(other: Operand): Operand { return Operand(this.value.times(other.value)) }

    operator fun div(other: Operand): Operand { return Operand(this.value.div(other.value)) }

    fun parseString(): String {
        return this.value.toString()
    }

    companion object {
        fun of(value: String): Operand {
            return Operand(
                value.toLongOrNull() ?: throw IllegalArgumentException("연산할 수 없는 문자열 입니다. value: $value")
            )
        }
    }
}
