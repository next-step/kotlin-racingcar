package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @ParameterizedTest
    @MethodSource("validTestcase")
    fun `calculate 에 유효한 값을 입력하면 사칙연산을 한다`(input: String, expected: Int) {
        val calculator = Calculator()
        val testValue = calculator.calculate(input)
        Assertions.assertThat(testValue).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1-", "2 + 3 + / 5", "2 + a / 5 - 5", "     "])
    fun `calculate 에 유효하지 않은 값을 입력하면 IllegalArgumentException 리턴한다`(input: String) {
        val calculator = Calculator()
        Assertions.assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        private fun validTestcase() = listOf(
            Arguments.of("1 - 1", 0),
            Arguments.of("2 + 3 + 5 / 5", 2),
            Arguments.of("2 + 3 / 5 - 5", -4),
            Arguments.of("3 / 3 + 5 * 5", 30),
        )
    }
}
