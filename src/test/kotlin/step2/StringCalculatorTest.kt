package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @DisplayName("연속된 입력에 대한 연산 테스트")
    @Test
    fun `연속된 입력에 대한 연산 테스트`() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @DisplayName("입력된 원소 갯수 확인 테스트")
    @Test
    fun `입력된 원소 갯수 확인 테스트`() {
        Assertions.assertThatThrownBy { StringCalculator.calculate("2 + 3 * 4 / 2 +") }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @DisplayName("연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2:3", "1 - 2:-1", "1 * 2:2", "1 / 2:0"], delimiter = ':')
    fun `연산 테스트`(input: String, output: Int) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output)
    }

    @DisplayName("빈 문자열에 대한 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈 문자열에 대한 예외처리 테스트`(input: String) {
        Assertions.assertThatThrownBy { StringCalculator(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("정수 검증 테스트")
    @Test
    fun `정수 검증 테스트`() {
        Assertions.assertThatThrownBy { StringCalculator.validateOperand("ABC") }
            .isInstanceOf(NumberFormatException::class.java)
    }
}
