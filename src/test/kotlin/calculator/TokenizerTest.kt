package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputValidateParserTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 빈 공백 문자이거나 Null일 경우 IllegalArgumentException 발생`(input: String?) {
        assertThrows<IllegalArgumentException> {
            InputValidateParser.validate(input)
        }.also {
            assertEquals("입력값은 null이거나 빈 공백 문자일 수 없다.", it.message)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "a + b - 0",
            "1 ㅍ 1 + 2",
        ]
    )
    fun `입력값이 모두 숫자 혹은 사칙 연산 부호로 구성되지 않는 경우 IllegalArgumentException 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidateParser.validate(input)
        }.also {
            assertEquals("입력값은 숫자, 사칙연산자, 공백만 들어올 수 있다.", it.message)
        }
    }

    @Test
    fun `입력값을 피연산자와 연산자로 구분하여 List로 반환`() {
        // given
        val input = " 1 + 2 - 3 * 4 / 5   "
        val expected = listOf("1", "+", "2", "-", "3", "*", "4", "/", "5")

        // when
        val actual = InputValidateParser.parse(input)

        // then
        assertEquals(expected, actual)
    }
}
