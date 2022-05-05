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
    fun `존재하지 않는 수식 기호 예외 발생`() {
        // given, when, then
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Calculator.calculate(1, 2, "&")
        }
        assertEquals("존재하지 않는 수식 기호입니다. (symbol: &)", exception.message)
    }

    @Test
    fun `나누는 수가 0일 때 예외 발생`() {
        // given, when, then
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Calculator.calculate(1, 0, "/")
        }
        assertEquals("나누는 수가 0이 될 수 없습니다.", exception.message)
    }

    @ParameterizedTest
    @CsvSource("1 + 2=3", "2 + 3 * 4 / 2=10", "4 - 2 / 2 * 5 + 1=6", delimiter = '=')
    fun `계산기 정상 동작`(expression: String, result: String) {
        // given
        val split = expression.split(" ")

        // when
        var calculatedResult = split[0].toInt()
        for (i in 1 until split.size step (2)) {
            val symbol = split[i]
            val num = split[i + 1].toInt()
            calculatedResult = Calculator.calculate(calculatedResult, num, symbol)
        }

        // then
        assertEquals(calculatedResult, result.toInt())
    }
}