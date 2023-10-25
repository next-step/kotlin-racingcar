package calculator

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class ExpressionKtTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " ", "  ", "\n"])
    fun `표현식이 공백이거나 널이면 IllegalArgumentException 발생한다`(expression: String?) {
        shouldThrow<IllegalArgumentException> {
            checkNullOrBlank(expression)
        }
    }
}
