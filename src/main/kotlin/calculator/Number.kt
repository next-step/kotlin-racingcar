package calculator

import java.lang.IllegalArgumentException

data class Number(private val value: Long) {

    constructor(value: String) : this(value.toLong())

    operator fun plus(other: Number): Number {
        return calculator.Number(this.value + other.value)
    }

    operator fun minus(other: Number): Number {
        return calculator.Number(this.value - other.value)
    }

    operator fun times(other: Number): Number {
        return calculator.Number(this.value * other.value)
    }

    operator fun div(other: Number): Number {
        if (other == ZERO) throw IllegalArgumentException("0 으로 나눌 수 없습니다.")
        return calculator.Number(this.value / other.value)
    }

    companion object {
        val ZERO = Number(0L)
    }
}
