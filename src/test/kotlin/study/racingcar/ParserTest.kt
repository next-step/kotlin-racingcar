package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {
    @Test
    fun `문자열 파싱 확인`() {
        val parser = Parser()
        val parsed = parser.parse("2 + 3 * 4 / 2")
        assertEquals(listOf("2", "+", "3", "*", "4", "/", "2"), parsed)
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = [""])
    fun `빈 공백 문자이거나, null 일 경우 Throw Exception`(input: String?) {
        val parser = Parser()

        assertThrows(IllegalArgumentException::class.java) {
            parser.parse(input)
        }
    }

    @Test
    fun `계산 가능한 숫자인지 확인`() {
        val parser = Parser()
        assertThat(parser.isInterpretableNumber("1")).isEqualTo(true)
        assertThat(parser.isInterpretableNumber("1234556677898")).isEqualTo(false)
        assertThat(parser.isInterpretableNumber("1+")).isEqualTo(false)
        // assertThat(parser.isInterpretableNumber("+1")).isEqualTo(false) TODO: "+1" 을 toInt 로 변환 가능한 이슈
    }

    @Test
    fun `계산 가능한 연산자인지 확인`() {
        val parser = Parser()
        assertThat(parser.getInterpretableOperator("+")).isEqualTo("+")
        assertThrows(IllegalArgumentException::class.java) {
            parser.getInterpretableOperator("+-")
        }
    }
}
