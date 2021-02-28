package calculator

import java.util.Objects
import java.util.Stack

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

    override fun toString(): String {
        return value.toString()
    }

    override fun calculate(resultStack: Stack<Number>) {
        resultStack.add(this)
    }

    companion object {
        fun of(value: String): Number {
            return Number(value.toIntOrNull() ?: throw IllegalArgumentException())
        }
    }
}
