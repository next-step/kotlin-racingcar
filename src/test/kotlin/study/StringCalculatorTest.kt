package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈 공백 문자인 경우 테스트`(input: String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산 대상 문자열이 null 또는 빈 값입니다.")
    }

    @Test
    fun `null이 들어온 경우 테스트`() {
        assertThatThrownBy { StringCalculator.calculate(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산 대상 문자열이 null 또는 빈 값입니다.")
    }

    @Test
    fun `잘못된 연산자가 들어온 경우 테스트`() {
        val testStr = "2 + 3 x 4 / 2 - 1"

        assertThatThrownBy { StringCalculator.calculate(testStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("잘못된 연산자가 포함되어 있습니다.")
    }

    @Test
    fun `정상 테스트`() {
        val testStr = "2 + 3 * 4 / 2 - 1"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(9)
    }
}
