package calculator.domain

class Number(val value: Int) {

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아님"))

    fun plus(number: Number) = Number(this.value + number.value)

    fun minus(number: Number) = Number(this.value - number.value)

    fun multiple(number: Number) = Number(this.value * number.value)

    fun divide(number: Number): Number {
        if (number == Number(0)) {
            throw IllegalArgumentException("0으로 나눌 수 없음")
        }

        return Number(this.value / number.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}
