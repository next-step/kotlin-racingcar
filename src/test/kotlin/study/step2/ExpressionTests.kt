package study.step2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ExpressionTests {

    @ParameterizedTest
    @MethodSource("validArithmeticExpressions")
    fun `식의 계산결과를 반환한다`(input: String, expected: Long) {
        val sut = Expression(Tokenizer(TokenListValidator()).tokenize(input))
        Assertions.assertEquals(expected, sut.calculate())
    }

    companion object {

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
    }
}
