package calculator

import java.lang.NumberFormatException
import java.util.Objects

class Number private constructor(private val value: Int) : Word {

    operator fun plus(other: Number) = Number(value + other.value)

    operator fun minus(other: Number) = Number(value - other.value)

    operator fun times(other: Number) = Number(value * other.value)

    operator fun div(other: Number) = Number(value / other.value)

    override fun equals(other: Any?): Boolean {
        if (other is Number) return this.value == other.value
        return false
    }

    override fun hashCode(): Int {
        return Objects.hash(value)
    }

    companion object {
        fun of(value: String): Number {
            val v = value.trim()
            if (v.isEmpty()) {
                throw IllegalArgumentException("the value must not empty")
            }

            try {
                return Number(v.toInt())
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("the value must number")
            }
        }
    }
}
