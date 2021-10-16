package step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {

    private val parser = InputParser()

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `인자가 빈값일 때 IllegalArgumentException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        assertEquals("인자로는 null 또는 빈값이 올 수 없습니다. $input", exception.message)
    }

    @Test
    fun `인자가 null 일 때 IllegalArgumentException`() {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(null)
        }

        assertEquals("인자로는 null 또는 빈값이 올 수 없습니다. null", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 , 3", "2 $ 3"])
    fun `사칙연산 기호가 아닌값이 들어갔을 때 IllegalArgumentException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        assertEquals("입력문자에는 숫자 또는 사칙연산 기호만 올 수 있습니다. $input", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / 2", "2 * 3 + 1 - 30 / 300"])
    fun `인자가 정상일경우 공백을 기준으로 split 한 결과를 반환`(input: String) {
        val expected = input.split(" ")
        val result = parser.parse(input)

        assertEquals(expected.size, result.size)

        result.forEachIndexed { index, str ->
            assertEquals(expected[index], str)
        }
    }
}
