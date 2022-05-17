package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class StringCalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun `입력값이 null인 경우`() {
        assertThatThrownBy {
            calculator.calculate(null)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 null 혹은 빈 값입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 blank인 경우`(input: String) {
        assertThatThrownBy {
            calculator.calculate(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 null 혹은 빈 값입니다.")
    }

    @Test
    fun `0으로 나눈 경우`() {
        assertThatThrownBy {
            calculator.calculate("1 / 0")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다")
    }

    @ParameterizedTest
    @MethodSource("plusArguments")
    fun `더하기`(input: String, expectedResult: Double) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("minusArguments")
    fun `빼기`(input: String, expectedResult: Double) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("multiplyArguments")
    fun `곱하기`(input: String, expectedResult: Double) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("divideArguments")
    fun `나누기`(input: String, expectedResult: Double) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("complexArguments")
    fun `사칙연산`(input: String, expectedResult: Double) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun plusArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1 + 1", 2.0),
                Arguments.arguments("-2147483648 + 2147483647", -1.0),
                Arguments.arguments("5.2 + 2.2", 7.4),
            )
        }

        @JvmStatic
        fun minusArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1 - 1", 0.0),
                Arguments.arguments("17328.125 - 17328.25", -0.125),
                Arguments.arguments("0.0 - 0.0", 0.0),
            )
        }

        @JvmStatic
        fun multiplyArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1 * 1", 1.0),
                Arguments.arguments("358 * 359", 128522.0),
                Arguments.arguments("5.58 * 9.32", 52.0056),
            )
        }

        @JvmStatic
        fun divideArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1 / 1", 1.0),
                Arguments.arguments("52.4 / 0.8", 65.5),
            )
        }

        @JvmStatic
        fun complexArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1 + 2 * 3 / 4", 2.25),
                Arguments.arguments("5 - 7 * 0 / 0.8", 0.0),
                Arguments.arguments("52.4 - 0.4 - 2 / 10", 5.0),
                Arguments.arguments("-3.0 * -3 * 9 - 20 - 1 / 6", 10.0),
                Arguments.arguments("2 + 3 * 4 / 2", 10.0),
            )
        }
    }
}
