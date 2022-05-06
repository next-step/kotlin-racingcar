package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("validInput")
    fun `계산 성공 테스트`(input: String, expected: Int) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2 + 3 ? 4", "2 +", "2 + 3 * 4 /", "+")
    fun `식 형태 오류`(input: String) {
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        private fun validInput() = listOf(
            Arguments.of("2 + 3 * 4 / 2", 10),
            Arguments.of("2", 2),
            Arguments.of("2 + 5", 7),
        )
    }
}
