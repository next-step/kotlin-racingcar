package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorProcessorTests {
    @Nested
    @DisplayName("CalculatorProcessor 를 이용하여 연산")
    inner class CalculatorProcessorTest {
        @ParameterizedTest(name = "입력값이 `{0}` 이면 `{1}`을 반환한다.")
        @CsvSource(
            value = [
                "2 + 3 * 4 / 2 = 10",
                "1 + 2 * 5 = 15"
            ],
            delimiter = '='
        )
        fun `사칙 연산 계산 성공`(inputStr: String, expected: Double) {
            val result = CalculatorProcessor.calculate(inputStr)
            assertThat(result).isEqualTo(expected)
        }
    }
}
