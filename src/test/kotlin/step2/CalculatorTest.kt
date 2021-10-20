package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `덧셈 테스트`() {
        var calculator = Calculator("2 + 3")
        assertThat(calculator.caculate()).isEqualTo(5)
    }

    @Test
    fun `뺄셈 테스트`() {
        var calculator = Calculator("3 - 2")
        assertThat(calculator.caculate()).isEqualTo(1)
    }

    @Test
    fun `곱셈 테스트`() {
        var calculator = Calculator("3 * 2")
        assertThat(calculator.caculate()).isEqualTo(6)
    }

    @Test
    fun `나눗셈 테스트`() {
        var calculator = Calculator("3 - 2")
        assertThat(calculator.caculate()).isEqualTo(1)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 테스트`() {
        var calculator = Calculator("2 + 3 * 4 / 2")
        assertThat(calculator.caculate()).isEqualTo(10)
    }
}
