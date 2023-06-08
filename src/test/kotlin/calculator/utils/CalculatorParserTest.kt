package calculator.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `문자열 파싱`(input: String) {
        val answer: List<String> = listOf("2", "+", "3", "*", "4", "/", "2")
        val extractedList = CalculatorParser.extract(input)
        assertEquals(answer, extractedList)
    }
}
