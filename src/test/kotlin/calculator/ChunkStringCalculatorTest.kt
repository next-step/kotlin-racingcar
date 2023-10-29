package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
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
        val tokenizedInputList = Tokenizer.tokenize(input)

        // when
        val actual = ChunkStringCalculator.calculate(
            operand1 = tokenizedInputList[0],
            operator = tokenizedInputList[1],
            operand2 = tokenizedInputList[2]
        )

        // then
        assertThat(actual).isEqualTo(expected)
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
        val tokenizedInputList = Tokenizer.tokenize(input)

        assertThrows<NumberFormatException> { // then
            ChunkStringCalculator.calculate( // when
                operand1 = tokenizedInputList[0],
                operator = tokenizedInputList[1],
                operand2 = tokenizedInputList[2]
            )
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
        val tokenizedInputList = Tokenizer.tokenize(input)

        assertThrows<IllegalArgumentException> { // then
            ChunkStringCalculator.calculate( // when
                operand1 = tokenizedInputList[0],
                operator = tokenizedInputList[1],
                operand2 = tokenizedInputList[2]
            )
        }.also {
            assertEquals("지원하지 않는 연산자가 들어왔다.", it.message)
        }
    }
}
