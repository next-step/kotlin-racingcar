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

    @Test
    fun `계산식이 비정상인 경우`() {
        assertThrows<IllegalArgumentException> { Calculation("1 1").toInt() }
    }

    @Test
    fun `0으로 나누는 경우`() {
        assertThrows<IllegalArgumentException> { Calculation("1 / 0").toInt() }
    }

    @Test
    fun `세 수의 합`() {
        assertThat(Calculation("3 + 4 + 5")).isEqualTo(12)
    }

    class Calculation(expression: String) : MathNumber() {
        private constructor(
            number: Number,
            nextExpression: String
        ) : this("$number $nextExpression")

        private val tokens: Tokens

        init {
            if (expression.isEmpty()) {
                throw IllegalArgumentException()
            }
            this.tokens = Tokens(expression)
        }

        override val value: Number
            get() {
                val result = with(tokens) { binaryOperation() }

                return if (tokens.emptyNext) result else Calculation(result, tokens.nextExpression)
            }

        private fun Tokens.binaryOperation() = when (operator) {
            "+" -> Sum(leftHandSide, rightHandSide)
            "-" -> Difference(leftHandSide, rightHandSide)
            "*" -> Product(leftHandSide, rightHandSide)
            "/" -> Quotient(leftHandSide, rightHandSide)
            else -> throw IllegalArgumentException()
        }
    }

    class Tokens(expression: String, private val tokens: List<String> = expression.split(" ")) {
        val leftHandSide: String
            get() = tokens[0]
        val operator: String
            get() = tokens[1]
        val rightHandSide: String
            get() = tokens[2]
        val emptyNext: Boolean
            get() = tokens.size == 3
        val nextExpression: String
            get() = tokens.slice(3 until tokens.size).joinToString(" ")
    }

    class Sum(lhs: String, rhs: String, override val value: Number = lhs.toInt() + rhs.toInt()) : MathNumber()

    class Difference(lhs: String, rhs: String, override val value: Number = lhs.toInt() - rhs.toInt()) : MathNumber()

    class Product(lhs: String, rhs: String, override val value: Number = lhs.toInt() * rhs.toInt()) : MathNumber()

    class Quotient(lhs: String, rhs: String) : MathNumber() {
        override val value: Number

        init {
            if (rhs.toInt() == 0) {
                throw IllegalArgumentException()
            }
            this.value = lhs.toInt() / rhs.toInt()
        }
    }

    abstract class MathNumber : Number() {
        protected abstract val value: Number

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
