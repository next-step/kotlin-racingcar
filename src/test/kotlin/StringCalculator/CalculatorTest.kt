package StringCalculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.IllegalArgumentException

class CalculatorTest {
    @Test
    fun `유효값 확인` () {
        val calculator = Calculator()
        // 잘못된 유효값
        assertThatThrownBy {
            calculator.calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
            calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
            calculator.calculate("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
            calculator.calculate(" &  ")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 현재는 올바른 인풋으로 간주
        assertThatThrownBy {
            calculator.calculate("+")
        }.isInstanceOf(NotImplementedError::class.java)
        assertThatThrownBy {
            calculator.calculate(" 12 * 7   12")
        }.isInstanceOf(NotImplementedError::class.java)
        assertThatThrownBy {
            calculator.calculate("*")
        }.isInstanceOf(NotImplementedError::class.java)
        assertThatThrownBy {
            calculator.calculate("123")
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