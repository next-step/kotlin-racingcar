package calculator.parser

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputParserTest {
    private val parser = InputParser

    @Test
    fun checkNullTest() {
        assertThat(parser.checkNull("test").getOrThrow()).isEqualTo("test")
        assertThat(parser.checkNull("3 + 4 / 2").getOrThrow()).isEqualTo("3 + 4 / 2")
        assertThatThrownBy { parser.checkNull(null).getOrThrow() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력은 null이 될 수 없습니다.")
    }

    @Test
    fun parseTest() {
        assertThat(parser.parse("4 + 5 - 2").getOrThrow())
            .isEqualTo(ParserOutput(listOf(4.0, 5.0, 2.0), listOf("+", "-")))
        assertThat(parser.parse("3 + 4 / 2").getOrThrow())
            .isEqualTo(ParserOutput(listOf(3.0, 4.0, 2.0), listOf("+", "/")))
        assertThatThrownBy { parser.parse("+ 3 + 4 / 2").getOrThrow() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("연산 숫자는 숫자 형태이어야 합니다.")
    }

    @Test
    fun validateTest() {
        assertThat(parser.validate(ParserOutput(listOf(4.0, 5.0, 2.0), listOf("+", "-"))).getOrThrow())
            .isEqualTo(ParserOutput(listOf(4.0, 5.0, 2.0), listOf("+", "-")))
        assertThatThrownBy { parser.validate(ParserOutput(listOf(0.0, -4.0, 2.0), listOf("+", "/"))).getOrThrow() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("모든 입력 숫자는 0보다 커야 합니다")
        assertThatThrownBy { parser.validate(ParserOutput(listOf(3.0, 4.0, 2.0), listOf("?", "/"))).getOrThrow() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("연산자 형식이 유효하지 않습니다.")
        assertThatThrownBy { parser.validate(ParserOutput(listOf(-3.0, 4.0, 2.0), listOf("?", "/"))).getOrThrow() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("모든 입력 숫자는 0보다 커야 합니다.\n연산자 형식이 유효하지 않습니다.")
    }
}
