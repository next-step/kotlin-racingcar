package study.step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `덧셈`() {
        val calc = Calculator()
        val input = "4 + 7"

        assertThat(11).isEqualTo(calc.calculate(input))
    }

    @Test
    fun `뺄셈`() {
        val calc = Calculator()
        val input = "7 - 4"

        assertThat(3).isEqualTo(calc.calculate(input))
    }

    @Test
    fun `곱셈`() {
        val calc = Calculator()
        val input = "3 * 4"

        assertThat(12).isEqualTo(calc.calculate(input))
    }

    @Test
    fun `나눗셈`() {
        val calc = Calculator()
        val input = "4 / 2"

        assertThat(2).isEqualTo(calc.calculate(input))
    }

    @Test
    fun `사칙연산`() {
        val calc = Calculator()
        val input = "2 + 3 - 3"

        assertThat(2).isEqualTo(calc.calculate(input))
    }

    @Test
    fun `사칙연산의 순서는 계산 우선순위가 아니라 입력 순서를 따른다`() {
        val calc = Calculator()
        val input = "3 * 2 + 2 / 2"

        assertThat(4).isEqualTo(calc.calculate(input))
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException Throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val input = ""
            calc.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val input = "3 & 5"
            calc.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `잘못된 순서를 가진 연산자가 들어올 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val input = "3 * * 5"
            calc.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `잘못된 순서를 가진 피연산자가 들어올 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val input = "3 * 2 2 3"
            calc.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
