package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CalculatorTest {

    @ParameterizedTest
    @MethodSource("successCalculateTest")
    fun `문자열 계산기가 수식에 따른 계산 결과가 성공`(inputs: String, result: Int) {
        // given
        val expression = Expression(inputs)
        val calculator = Calculator(expression)

        // when
        val actual = calculator.calculate()

        // then
        val expected = result
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("failureCalculateTest")
    fun `수식이 잘못되어 계산을 실패`(inputs: String, result: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                // given
                val expression = Expression(inputs)
                val calculator = Calculator(expression)

                // when
                val actual = calculator.calculate()

                // then
                val expected = result
                assertThat(actual).isEqualTo(expected)
            }
    }

    companion object {

        @JvmStatic
        fun successCalculateTest() = Stream.of(
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

        @JvmStatic
        fun failureCalculateTest() = Stream.of(
            Arguments.of("안녕하세요", 3),
            Arguments.of("잘부탁드립니다", 6),
            Arguments.of("17 null 1 - 2 - 3 - 5 - 6", 0),
        )
    }
}