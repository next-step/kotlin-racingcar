package study

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalcSyntaxCheckerTest {

    @ParameterizedTest()
    @ValueSource(strings = ["", " ", "\r\n", "\t"])
    fun `빈 공백인 수식인 경우 예외 처리`(expr: String) {
        // when
        val throwableAction = {
            CalcSyntaxChecker.validate(expr)
        }

        // then
        shouldThrow<IllegalArgumentException>(throwableAction)
    }
}
