package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringCalculatorTest {

    @Test
    fun `문자열을 순차 연산이 가능하다`() {
        // given
        val calculator = StringCalculator()
        // when
        // then
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }
}
