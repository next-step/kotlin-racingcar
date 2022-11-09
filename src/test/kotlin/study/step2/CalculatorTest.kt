package study.step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `사칙연산`() {
        val calc = Calculator()
        val formula = "2 + 3 - 3"

        assertThat(calc.calculate(formula)).isEqualTo(2)
    }

    @Test
    fun `사칙연산의 순서는 계산 우선순위가 아니라 입력 순서를 따른다`() {
        val calc = Calculator()
        val formula = "3 * 2 + 2 / 2"

        assertThat(calc.calculate(formula)).isEqualTo(4)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException Throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val formula = ""
            calc.calculate(formula)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val formula = "3 & 5"
            calc.calculate(formula)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `잘못된 순서를 가진 연산자가 들어올 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val formula = "3 * * 5"
            calc.calculate(formula)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `잘못된 순서를 가진 피연산자가 들어올 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            val calc = Calculator()
            val formula = "3 * 2 2 3"
            calc.calculate(formula)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
