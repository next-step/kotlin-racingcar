package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ChunkStringCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "1 + 2, 3",
        "1 - 2, -1",
        "1 * 2, 2",
        "1 / 2, 0"
    )
    fun `피연산자와 연산자 순서가 맞았을 경우`(input: String, expected: String) {
        // given
        val wholeElements = InputValidateParser.parse(input)
        val chunkStringCalculator = ChunkStringCalculator(wholeElements)

        // when
        val actual = chunkStringCalculator.calculate()

        // then
        assertThat(actual).isEqualTo(expected)
        assertThat(chunkStringCalculator.isValidResult()).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1 + +",
            "- 1 1",
            "+ 1 + "
        ]
    )
    fun `피연산자가 Int형이 아닌 경우 NumberFormatException 발생`(input: String) {
        // given
        val wholeElements = InputValidateParser.parse(input)
        val chunkStringCalculator = ChunkStringCalculator(wholeElements)

        assertThrows<NumberFormatException> { // then
            chunkStringCalculator.calculate() // when
        }.also {
            assertEquals("숫자형이 아닌 피연산자가 들어왔다.", it.message)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1 1 2 ",
            "1 // 2",
            "1 ** 2",
            "1 -- 1"
        ]
    )
    fun `지원하는 연산자가 아닌 경우 IllegalArgumentException 발생`(input: String) {
        // given
        val wholeElements = InputValidateParser.parse(input)
        val chunkStringCalculator = ChunkStringCalculator(wholeElements)

        assertThrows<IllegalArgumentException> { // then
            chunkStringCalculator.calculate() // when
        }.also {
            assertEquals("지원하지 않는 연산자가 들어왔다.", it.message)
        }
    }
}
