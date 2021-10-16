package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    private fun inputStringArrayProvider(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("10000", "10000"),
            Arguments.of("1 + 2", "3"),
            Arguments.of("5 - 7 * 3", "-6"),
            Arguments.of("5 * 0 + -25.53", "-25.53"),
            Arguments.of("-2.4 / 1.2 * 3 - 4.5", "-10.5"),
            Arguments.of("10 * 3 / 4 + 50", "57.5"),
            Arguments.of("20 - 3 * 5 / 30 + 7.5", "10.333333"),
        )
    }

    private fun wrongInputStringArrayProvider(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("1 +"),
            Arguments.of("5 - 7 *"),
            Arguments.of("5 * 0 +"),
            Arguments.of("-2.4 / 1.2 * 3 -"),
        )
    }

    @ParameterizedTest
    @MethodSource("inputStringArrayProvider")
    fun `계산기 테스트`(input: String, expected: String) {
        val result = Calculator.calculate(input)

        assertThat(result.value).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "      "])
    @NullAndEmptySource
    fun `계산기 null이나 공백 문자열 입력 테스트`(input: String?) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Calculator.NULL_OR_EMPTY_INPUT)
    }

    @ParameterizedTest
    @MethodSource("wrongInputStringArrayProvider")
    fun `인자 개수가 잘못 입력된 테스트`(input: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Calculator.WRONG_NUMBER_OF_OPERANDS)
    }
}
