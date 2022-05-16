package calculator

import StringCalculator
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
                Arguments.arguments("17328.58 - 17328.59", -0.1),
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
    }
}
