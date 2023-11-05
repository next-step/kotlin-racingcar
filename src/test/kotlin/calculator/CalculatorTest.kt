package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `input 값에 이상이 없는 경우`() {
        val input = "2 + 3 * 4 / 2"
        val expect = 10
        val calculator = Calculator()
        val actual = calculator.run(input)
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `입력값이 공백인 경우`() {
        val input = " "
        val calculator = Calculator()
        assertThrows<IllegalArgumentException> ("입력값이 null이거나 빈 공백 문자입니다.") { calculator.run(input) }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        val input = "4 5 3 * 2"
        val calculator = Calculator()
        assertThrows<IllegalArgumentException> ("사칙연산 기호가 아닙니다.") { calculator.run(input) }
    }
}
