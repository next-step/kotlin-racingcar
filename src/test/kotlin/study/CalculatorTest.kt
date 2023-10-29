package study

import calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("덧셈")
    fun `덧셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("뺄셈")
    fun `뺄셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("곱셈")
    fun `곱셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("나눗셈")
    fun `나눗셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("입력값 오류")
    fun `입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?, expected: String) {
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("사칙연산 기호 오류")
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String, expected: String) {
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("사칙연산")
    fun `사칙연산을 모두 포함하는 기능 구현`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun `덧셈`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 2 + 3", "6"),
                Arguments.of("1 + 3 + 5 + 7", "16"),
            )
        }

        @JvmStatic
        fun `뺄셈`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("10 - 5 - 3", "2"),
                Arguments.of("3 - 2 - 1 - 1 - 0", "-1"),
            )
        }

        @JvmStatic
        fun `곱셈`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("10 * 10 * 10", "1000"),
                Arguments.of("10 * 1 * 0", "0"),
                Arguments.of("10 * 1 * -1", "-10"),
            )
        }

        @JvmStatic
        fun `나눗셈`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("4 / 2 / 1", "2"),
                Arguments.of("1 / 10", "0.1"),
            )
        }

        @JvmStatic
        fun `입력값 오류`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(null, "입력값이 null 입니다."),
                Arguments.of("", "인자가 3개 이상이어야 합니다."),
                Arguments.of("  ", "인자에 빈 공백 문자가 포함되어 있습니다."),
            )
        }

        @JvmStatic
        fun `사칙연산 기호 오류`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 ! 1", "연산자가 아닙니다."),
                Arguments.of("1 @ 1", "연산자가 아닙니다."),
            )
        }

        @JvmStatic
        fun `사칙연산`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("5 + 4 - 3 * 2 / 1", "12"),
                Arguments.of("5 / 4 * 3 - 2 + 1", "2.75")
            )
        }
    }
}
