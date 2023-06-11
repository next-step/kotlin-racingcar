package study.step2

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TokenListValidatorTests {

    @ParameterizedTest
    @MethodSource("illegalArithmeticExpressionFormats")
    fun `사칙연산식의 형식이 올바르지 않을 경우 IllegalArgumentException 을 발생시킨다`(input: String, message: String) {
        val sut = TokenListValidator()
        assertThrows<IllegalArgumentException>(message) {
            sut.validate(input.split(" "))
        }
    }

    companion object {

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
    }
}
