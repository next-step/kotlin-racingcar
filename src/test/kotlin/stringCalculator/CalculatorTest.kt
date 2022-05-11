package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CalculatorTest {

    @ParameterizedTest
    @MethodSource("testcase")
    fun `calculate 결과`(input: String, expected: Int) {
        val calculator = Calculator()
        val testValue = calculator.calculate(input)
        Assertions.assertThat(testValue).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun testcase() = listOf(
            Arguments.of("1 - 1", 0),
            Arguments.of("2 + 3 + 5 / 5", 2),
            Arguments.of("2 + 3 / 5 - 5", -4),
            Arguments.of("3 / 3 + 5 * 5", 30),
        )
    }
}
