package week1.calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `더하기`() {
        assertThat(calculator.add(1, 2)).isEqualTo(3)
        assertThat(calculator.add(123000, 456)).isEqualTo(123456)
    }

    @Test
    fun `빼기`() {
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1)
        assertThat(calculator.subtract(10, 2)).isEqualTo(8)
    }

    @Test
    fun `곱하기`() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2)
        assertThat(calculator.multiply(123, 456)).isEqualTo(56088)
    }

    @Test
    fun `나누기`() {
        assertThat(calculator.divide(1, 2)).isEqualTo(0)
        assertThat(calculator.divide(100, 9)).isEqualTo(11)
    }

    @Test
    fun `입력 내용 검증`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.checkInput("")
            calculator.checkInput(" ")
            calculator.checkInput("  ")
            calculator.checkInput("\n")
        }
        assertThatCode {
            calculator.checkInput("123")
            calculator.checkInput("3+2*4-1/2")
        }
    }

    @Test
    fun `식 계산`() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(calculator.calculate("1 + 2 + 3 + 4 + 5")).isEqualTo(15)
    }
}