package study.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import study.calculator.Parser

class ParserTest {
    @Test
    fun `문자열 파싱 확인`() {
        val parser = Parser()
        val input = "2 + 3"
        val parsed = parser.parse(input)

        assertEquals(
            parsed[0].operand + " " + parsed[1].operator + " " + parsed[2].operand,
            input
        )
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 공백 문자이거나, null 일 경우 Throw Exception`(input: String?) {
        val parser = Parser()

        assertThrows(IllegalArgumentException::class.java) {
            parser.parse(input)
        }
    }
}
