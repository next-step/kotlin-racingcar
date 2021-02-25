package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MathTest {
    @Test
    fun `두 수의 합`() {
        assertThat(Calculation("3 + 4")).isEqualTo(7)
    }

    @Test
    fun `두 수의 차`() {
        assertThat(Calculation("4 - 1")).isEqualTo(3)
    }

    @Test
    fun `두 수의 곱`() {
        assertThat(Calculation("4 * 3")).isEqualTo(12)
    }

    @Test
    fun `두 수의 몫`() {
        assertThat(Calculation("4 / 2")).isEqualTo(2)
    }

    @Test
    fun `예약되지 않은 연산자`() {
        assertThrows<IllegalArgumentException> { Calculation("4 $ 2").toInt() }
    }

    @Test
    fun `계산식이 없는 경우`() {
        assertThrows<IllegalArgumentException> { Calculation("").toInt() }
    }

    class Calculation(private val expression: String) : Number() {
        private val value: Number
            get() {
                val token = expression.split(" ")
                return when (token[1]) {
                    "+" -> token[0].toInt() + token[2].toInt()
                    "-" -> token[0].toInt() - token[2].toInt()
                    "*" -> token[0].toInt() * token[2].toInt()
                    "/" -> token[0].toInt() / token[2].toInt()
                    else -> throw IllegalArgumentException()
                }
            }

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
