package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("arrangePlusTest")
    fun 덧셈(input: String, expected: Double) {
        val calculator = Calculator(input)
        val actual = calculator.calculate()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("arrangeMinusTest")
    fun 뺄셈(input: String, expected: Double) {
        val calculator = Calculator(input)
        val actual = calculator.calculate()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("arrangeMultiplyTest")
    fun 곱셈(input: String, expected: Double) {
        val calculator = Calculator(input)
        val actual = calculator.calculate()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("arrangeDivideTest")
    fun 나눗셈(input: String, expected: Double) {
        val calculator = Calculator(input)
        val actual = calculator.calculate()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("arrangeInvalidInputTest")
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?, expected: Double) {
        val calculator = Calculator(input)
        assertThatThrownBy { calculator.calculate() }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("arrangeInvalidArithmeticSymbolTest")
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String, expected: Double) {
        val calculator = Calculator(input)
        assertThatThrownBy { calculator.calculate() }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("arrangeAllArithmeticSymbolTest")
    fun `사칙 연산을 모두 포함하는 기능 구현`(input: String, expected: Double) {
        val calculator = Calculator(input)
        val actual = calculator.calculate()
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arrangePlusTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 1", 2),
                Arguments.of("99 + 2", 101)
            )
        }

        @JvmStatic
        fun arrangeMinusTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 - 2", -1),
                Arguments.of("100 - 1", 99)
            )
        }

        @JvmStatic
        fun arrangeMultiplyTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 * 0", 0),
                Arguments.of("9 * 9", 81)
            )
        }

        @JvmStatic
        fun arrangeDivideTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 / 2", 0.5),
                Arguments.of("12 / 4", 3)
            )
        }

        @JvmStatic
        fun arrangeInvalidInputTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 3)
            )
        }

        @JvmStatic
        fun arrangeInvalidArithmeticSymbolTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 = 0", 0),
                Arguments.of("12 ~ 4", 3)
            )
        }

        @JvmStatic
        fun arrangeAllArithmeticSymbolTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("4 / 2 * 3 + 2", 8)
            )
        }
    }
}
