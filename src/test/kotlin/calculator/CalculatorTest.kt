package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun 덧셈() {
        val input = "1 + 2 + 3 + 4"
        assertThat(Calculator(input).run()).isEqualTo(10.0)
    }

    @Test
    fun 뺄셈() {
        val input = "30 - 2 - 2"
        assertThat(Calculator(input).run()).isEqualTo(26.0)
    }

    @Test
    fun 곱셈() {
        val input = "2 * 5"
        assertThat(Calculator(input).run()).isEqualTo(10.0)
    }

    @Test
    fun 나눗셈() {
        val input = "100 / 10"
        assertThat(Calculator(input).run()).isEqualTo(10.0)
    }

    @Test
    fun `사칙 연산을 모두 포함`() {
        val input = "2 + 3 * 4 / 2"
        assertThat(Calculator(input).run()).isEqualTo(10.0)
    }

    @Test
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            val input = ""
            Calculator(input).run()
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            val input = "2 - 3 & 2"
            Calculator(input).run()
        }
    }
}
