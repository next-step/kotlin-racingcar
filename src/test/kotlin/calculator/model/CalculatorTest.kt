package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("계산기 테스트")
class CalculatorTest {

    @Test
    fun `수식이 공백일 때 예외 발생`() {
        // given, when, then
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Calculator.calculate(" ")
        }
        assertEquals("수식은 공백이 될 수 없습니다.", exception.message)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "1 + 2 = 3",
        "2 + 3 * 4 / 2 = 10",
        "4 - 2 / 2 * 5 + 1 = 6",
        delimiter = '='
    )
    fun `계산기 정상 동작`(expression: String, result: String) {
        // when, then
        assertEquals(Calculator.calculate(expression), result.toInt())
    }
}
