package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorJUnitTest {
    @Test
    fun `덧셈 테스트`() {
        val actual = Calculator.execute("1 + 2")

        assertThat(3).isEqualTo(actual)
    }

    @Test
    fun `뺄셈 테스트`() {
        val actual = Calculator.execute("2 - 1")

        assertThat(1).isEqualTo(actual)
    }

    @Test
    fun `곱셈 테스트`() {
        val actual = Calculator.execute("2 * 3")

        assertThat(6).isEqualTo(actual)
    }

    @Test
    fun `나눗셈 테스트`() {
        val actual = Calculator.execute("4 / 2")

        assertThat(2).isEqualTo(actual)
    }

    @Test
    fun `사칙연산 테스트`() {
        val actual = Calculator.execute("4 * 2 + 2 / 10")

        assertThat(1).isEqualTo(actual)
    }
}
