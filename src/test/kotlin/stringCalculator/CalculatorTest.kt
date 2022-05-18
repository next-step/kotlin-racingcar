package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @MethodSource("validTestcase")
    fun `수식이 입력되면 사칙연산을 한다`(input: String, expected: Int) {
        val testValue = calculator.calculate(input)
        Assertions.assertThat(testValue).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1-", "2 + 3 + / 5", "2 + a / 5 - 5", "     "])
    fun `올바르지 않은 수식이 입력되면 IllegalArgumentException 이 발생한다`(input: String) {
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
