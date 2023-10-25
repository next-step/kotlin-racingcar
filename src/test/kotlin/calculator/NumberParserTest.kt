package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class NumberParserTest {

    @ParameterizedTest
    @CsvSource(value = ["1,1", "2,2", "3,3"])
    fun `숫자를 잘 파싱한다`(value: String, result: Int) {
        assertEquals(result, NumberParser.parse(value))
    }

    @ParameterizedTest
    @CsvSource(value = ["a", "b", "c"])
    fun `숫자가 아닌 값이 들어오면 예외를 던진다`(value: String) {
        assertThrows<IllegalArgumentException> {
            NumberParser.parse(value)
        }
    }
}
