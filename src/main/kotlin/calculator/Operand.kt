package calculator

data class Operand(val value: Long) {
    fun plus(other: Operand) = Operand(this.value.plus(other.value))

    fun minus(other: Operand) = Operand(this.value.minus(other.value))

    fun multiply(other: Operand) = Operand(this.value.times(other.value))

    fun divide(other: Operand) = Operand(this.value.div(other.value))

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
