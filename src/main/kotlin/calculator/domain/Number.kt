package calculator.domain

data class Number(val value: Int) {

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아님"))

    operator fun plus(number: Number) = Number(this.value + number.value)

    operator fun minus(number: Number) = Number(this.value - number.value)

    operator fun times(number: Number) = Number(this.value * number.value)

    operator fun div(number: Number): Number {
        require(isNotZero(number)) { "0으로 나눌 수 없음" }
        return Number(this.value / number.value)
    }

    private fun isNotZero(number: Number): Boolean {
        return number != Number(0)
    }
}
