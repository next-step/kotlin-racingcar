package study.step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringCalculatorTests {

    private val sut = StringCalculator()

    @ParameterizedTest
    @MethodSource("invalidInputs")
    fun `비어있거나 null 인 입력값에 대해서 IllegalArgumentException 을 발생시킨다`(input: String?) {
        assertThrows<IllegalArgumentException> {
            sut.calculate(input)
        }
    }

    @ParameterizedTest
    @MethodSource("validArithmeticExpressions")
    fun `유효한 사칙연산식에 대하여 식의 계산결과를 반환한다`(input: String, expected: Long) {
        assertEquals(expected, sut.calculate(input))
    }

    @ParameterizedTest
    @MethodSource("illegalArithmeticExpressionFormats")
    fun `사칙연산식의 형식이 올바르지 않을 경우 IllegalArgumentException 을 발생시킨다`(input: String, message: String) {
        assertThrows<IllegalArgumentException>(message) {
            sut.calculate(input)
        }
    }

    @ParameterizedTest
    @MethodSource("divideByZeroExpressions")
    fun `0으로 나누는 경우 ArithmeticException 이 발생한다`(input: String) {
        assertThrows<ArithmeticException> {
            sut.calculate(input)
        }
    }

    companion object {
        @JvmStatic
        fun invalidInputs(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(null),
                Arguments.of(""),
                Arguments.of(" ")
            )
        }

        @JvmStatic
        fun validArithmeticExpressions(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("1 + 2", 3),
                Arguments.of("1 - 2", -1),
                Arguments.of("2 - 1", 1),
                Arguments.of("1 - 1", 0),
                Arguments.of("1 * 2", 2),
                Arguments.of("1 * 0", 0),
                Arguments.of("1 / 2", 0),
                Arguments.of("1 / 1", 1),
                Arguments.of("2 / 1", 2),
                Arguments.of("1 + 2 * 3 / 4", 2)
            )
        }

        @JvmStatic
        fun illegalArithmeticExpressionFormats(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("+", "식의 첫 글자는 연산기호가 될 수 없습니다"),
                Arguments.of("++", "식의 첫 글자는 연산기호가 될 수 없습니다"),
                Arguments.of("+ 3", "식의 첫 글자는 연산기호가 될 수 없습니다"),
                Arguments.of("3 + -", "연산기호가 연속해서 등장할 수 없습니다"),
                Arguments.of("3 3 + 1", "숫자가 연속해서 등장할 수 없습니다"),
                Arguments.of("3 + 2 -", "식의 마지막 글자는 연산기호가 될 수 없습니다"),
                Arguments.of(" 3 + 2", "식은 공백으로 시작할 수 없습니다"),
                Arguments.of(" 3 + 2", "식은 공백으로 끝날수 없습니다"),
                Arguments.of(" 3 $ 2", "사칙연산 기호가 아닌 기호가 등장할 수 없습니다")
            )
        }

        @JvmStatic
        fun divideByZeroExpressions(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 / 0")
            )
        }
    }
}
