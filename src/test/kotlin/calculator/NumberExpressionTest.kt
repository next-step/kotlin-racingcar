package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class NumberExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = ["32", "32.0", "1.32", "-1.3", "-4.0", "-5"])
    fun `올바른 생성`(input: String) {
        assertDoesNotThrow {
            NumberExpression(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "+", "32.a", "a5", "5a", "."])
    fun `실수가 아닌 값으로 생성하면 예외`(input: String) {
        assertThatThrownBy {
            NumberExpression(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${input}는 실수가 아닙니다.")
    }
}
