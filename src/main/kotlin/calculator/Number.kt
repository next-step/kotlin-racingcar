package calculator

data class Number(val value: Long) {
    fun plus(other: Number) = Number(this.value.plus(other.value))

    fun minus(other: Number) = Number(this.value.minus(other.value))

    fun multiply(other: Number) = Number(this.value.times(other.value))

    fun divide(other: Number) = Number(this.value.div(other.value))

    fun parseString(): String {
        return this.value.toString()
    }

    companion object {
        fun of(value: String): Number {
            return Number(
                value.toLongOrNull() ?: throw IllegalArgumentException("연산할 수 없는 문자열 입니다. value: $value")
            )
        }
    }
}
