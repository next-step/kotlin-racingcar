package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `유효한 문자열 넣을 시 결과 확인`() {
        // given
        val splitString = "2 + 3 * 4 / 2".split(" ")

        // then
        assertThat(StringCalculator.calculate(splitString))
            .isEqualTo(Operand(10.0))
    }
}
