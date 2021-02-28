package calculator.domain

data class Number(val value: Int) {

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아님"))

    operator fun plus(number: Number) = Number(this.value + number.value)

    operator fun minus(number: Number) = Number(this.value - number.value)

    operator fun times(number: Number) = Number(this.value * number.value)

    operator fun div(number: Number): Number {
        if (number == Number(0)) {
            throw IllegalArgumentException("0으로 나눌 수 없음")
        }

        return Number(this.value / number.value)
    }
}
