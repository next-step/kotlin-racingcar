package study.step2

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ExpressionFactoryTests {

    @ParameterizedTest
    @MethodSource("invalidInputs")
    fun `비어있거나 null 인 입력값에 대해서 IllegalArgumentException 을 발생시킨다`(input: String?) {
        val sut = ExpressionFactory(Tokenizer(TokenListValidator()))
        assertThrows<IllegalArgumentException> {
            sut.create(input)
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
    }
}
