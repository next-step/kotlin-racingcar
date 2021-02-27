package study.step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputConsoleTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "      "])
    fun `isBlank가 빈공백 문자에 true를 리턴하는지`(input: String) {
        assertTrue(input.isBlank())
    }

    @Test
    fun `null을 입력할 경우`() {
        Assertions.assertThatThrownBy {
            InputConsole().splitExpression(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("IllegalArgumentException")
    }

    @Test
    fun `공백을 입력할 경우`() {
        Assertions.assertThatThrownBy {
            InputConsole().splitExpression(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
