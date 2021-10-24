package StringCalculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `유효값 확인` () {
        val calculator = Calculator()
        // 잘못된 입력값들
        // null
        assertThatThrownBy {
            calculator.calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
        // empty string
        assertThatThrownBy {
            calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // white space
        assertThatThrownBy {
            calculator.calculate("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 잘못된 기호
        assertThatThrownBy {
            calculator.calculate(" &  ")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 연산 기호 하나만 있음
        assertThatThrownBy {
            calculator.calculate("+")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 숫자의 연속
        assertThatThrownBy {
            calculator.calculate("123 12")
        }.isInstanceOf(IllegalArgumentException::class.java)

        // 유효값들
        assertThatThrownBy {
            calculator.calculate("123")
        }.isInstanceOf(NotImplementedError::class.java)
        assertThatThrownBy {
            calculator.calculate("+123")
        }.isInstanceOf(NotImplementedError::class.java)
        assertThatThrownBy {
            calculator.calculate("-123")
        }.isInstanceOf(NotImplementedError::class.java)
        assertThatThrownBy {
            calculator.calculate("123 + 12")
        }.isInstanceOf(NotImplementedError::class.java)
    }

    @Test
    fun `덧셈` () {
        val calculator = Calculator()
        assertThat(calculator.add(3, 2)).isEqualTo(5)
    }

    @Test
    fun `뺄셈` () {
        val calculator = Calculator()
        assertThat(calculator.subtract(3, 2)).isEqualTo(1)
    }

    @Test
    fun `곱셈` () {
        val calculator = Calculator()
        assertThat(calculator.multiply(3, 2)).isEqualTo(6)
    }

    @Test
    fun `나눗셈` () {
        val calculator = Calculator()
        assertThat(calculator.divide(3, 2)).isEqualTo(1)
    }
}