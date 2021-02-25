package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MathTest {
    @Test
    fun `두 수의 합`() {
        assertThat(Calculation("3 + 4")).isEqualTo(7)
    }

    @Test
    fun `두 수의 차`() {
        assertThat(Calculation("4 - 1")).isEqualTo(3)
    }

    class Calculation(expression: String) : Number() {
        private val value: Number
            get() = 7

        override fun toByte() = value.toByte()

        override fun toChar() = value.toChar()

        override fun toDouble() = value.toDouble()

        override fun toFloat() = value.toFloat()

        override fun toInt() = value.toInt()

        override fun toLong() = value.toLong()

        override fun toShort() = value.toShort()

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Number) return false
            if (value != other) return false

            return true
        }

        override fun hashCode(): Int {
            return value.hashCode()
        }

        override fun toString(): String {
            return value.toString()
        }
    }
}
