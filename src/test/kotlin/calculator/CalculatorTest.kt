package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculateTest")
    fun `문자열 계산기의 결과가 올바르게 나오는 지 확인하는 테스트`(inputs: String, result: Int) {
        // given
        val expression = Expression(inputs)
        val calculator = Calculator(expression)

        // when
        val actual = calculator.result

        // then
        val expected = result
        assertThat(actual).isEqualTo(expected)
    }

    companion object {

        @JvmStatic
        fun calculateTest() = Stream.of(
            // 덧셈
            Arguments.of("1 + 2", 3),
            Arguments.of("1 + 2 + 3", 6),
            Arguments.of("1 + 2 + 3 + 5 + 6", 17),

            // 뺄셈
            Arguments.of("17 - 1 - 2 - 3 - 5 - 6", 0),
            Arguments.of("6 - 1 - 2 - 3", 0),
            Arguments.of("3 - 2 - 1", 0),

            // 곱셈
            Arguments.of("3 * 2 * 2", 12),
            Arguments.of("2 * 2 * 2", 8),
            Arguments.of("5 * 3 * 2", 30),

            // 나눗셈
            Arguments.of("12 / 3 / 2 / 2", 1),
            Arguments.of("8 / 2 / 2 / 2", 1),
            Arguments.of("30 / 5 / 3 / 2", 1),
            Arguments.of("30 / 0", 0),
        )
    }
}