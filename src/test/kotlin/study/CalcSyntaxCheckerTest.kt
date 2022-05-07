package study

import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Assertions.assertThrowsExactly
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalcSyntaxCheckerTest {

    @ParameterizedTest()
    @ValueSource(strings = ["", " ", "\r\n", "\t"])
    fun `빈 공백인 수식을 검증할 경우 예외 발생`(expr: String) {
        // when
        val result = assertThrowsExactly(IllegalArgumentException::class.java) {
            CalcSyntaxChecker.validate(expr)
        }

        // then
        result.shouldHaveMessage(CalcSyntaxChecker.EMPTY_EXPRESSION_EXCEPTION)
    }
}
