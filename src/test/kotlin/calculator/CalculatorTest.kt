package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    @DisplayName("예시로 나온 계산이 성공하는지 확인.")
    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2,10", "15 - 3 / 3,4")
    fun `계산 성공`(input: String, result: Int) {
        assertThat(Calculator(input).calculate())
            .isEqualTo(result)
    }

    // NOTE: 입력값이 null 인 경우는 컴파일 단계에서 걸러지기 때문테 테스트를 할 필요가 없다.
    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    fun `입력값이 빈 공백 문자`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator(input).calculate() }
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    fun `사친연산 기호가 아님`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator("5 % 2").calculate() }
            .withMessage("허용되지 않은 연산자 입니다.")
    }
}
