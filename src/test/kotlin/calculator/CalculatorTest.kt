package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `더하기`() {
        val calculator = Calculator()

        assertThat(calculator.plus(1, 2)).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        val calculator = Calculator()

        assertThat(calculator.minus(2, 1)).isEqualTo(1)
    }

    @Test
    fun `곱하기`() {
        val calculator = Calculator()

        assertThat(calculator.multiply(2, 3)).isEqualTo(6)
    }

    @Test
    fun `나누기`() {
        val calculator = Calculator()

        assertThat(calculator.division(8, 2)).isEqualTo(4)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("1 , 1")
        }
    }

    @Test
    fun `입력값이 빈 공백일 경우 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("")
        }

        assertThrows<IllegalArgumentException> {
            calculator.calculate(" ")
        }

        assertThrows<IllegalArgumentException> {
            calculator.calculate("\t")
        }

        assertThrows<IllegalArgumentException> {
            calculator.calculate("\n")
        }
    }

    @Test
    fun `사칙연산 문자열을 받아 계산한 값을 반환한다`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("2 + 9 - 1 * 10 / 5")).isEqualTo(20)
    }
}
