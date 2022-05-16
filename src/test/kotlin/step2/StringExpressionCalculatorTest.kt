package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class StringExpressionCalculatorTest {
    @ParameterizedTest
    @MethodSource("validInput")
    fun `계산 성공 테스트`(input: String, expected: Int) {
        val result = StringExpressionCalculator.calculate(input)
        assertThat(result).isEqualTo(expected)
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
