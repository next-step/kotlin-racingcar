package study.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class ParserTest {
    @Test
    fun `문자열 파싱 확인`() {
        val parser = Parser()
        val input = "2 + 3"
        val parsed = parser.parse(input)

        assertEquals(
            parsed[0].getOperand() + " " + parsed[1].getOperator() + " " + parsed[2].getOperand(),
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
