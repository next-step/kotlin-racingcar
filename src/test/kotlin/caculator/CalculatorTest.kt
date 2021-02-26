package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CalculatorTest {
    companion object {
        @JvmStatic
        fun addSource(): Stream<Arguments> {
            return Stream.of(
                arguments("1 + 1", 2),
                arguments("1 + 3", 4),
                arguments("1 + 2 + 3", 6)
            )
        }

        @JvmStatic
        fun minusSource(): Stream<Arguments> {
            return Stream.of(
                arguments("1 - 1", 0),
                arguments("1 - 3", -2),
                arguments("3 - 1", 2)
            )
        }

        @JvmStatic
        fun multipleSource(): Stream<Arguments> {
            return Stream.of(
                arguments("1 * 0", 0),
                arguments("1 * 2", 2),
                arguments("1 * 2 * 3", 6)
            )
        }

        @JvmStatic
        fun divideSource(): Stream<Arguments> {
            return Stream.of(
                arguments("2 / 1", 2),
                arguments("4 / 2 / 2", 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("addSource")
    fun `덧셈`(input: String, expect: Int) {
        val calculator = Calculator()
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("minusSource")
    fun `뺄샘`(input: String, expect: Int) {
        val calculator = Calculator()
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("multipleSource")
    fun `곱셈`(input: String, expect: Int) {
        val calculator = Calculator()
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("divideSource")
    fun `나눗셈`(input: String, expect: Int) {
        val calculator = Calculator()
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expect)
    }
}
