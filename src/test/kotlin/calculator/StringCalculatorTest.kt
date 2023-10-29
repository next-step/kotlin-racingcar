package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "1 + 2, 3",
        "1 + 2 + 3, 6",
        "1 + 2 + 3 + 4, 10",
    )
    fun `덧셈 연산 정상 수행 확인`(input: String, expected: String) {
        // given
        commonTest(input, expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1 - 2, -1",
        "1 - 2 - 3, -4",
        "1 - 2 - 3 - 4, -8"
    )
    fun `뺄셈 연산 정상 수행 확인`(input: String, expected: String) {
        commonTest(input, expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1 * 2, 2",
        "1 * 2 * 3, 6",
        "1 * 2 * 3 * 4, 24"
    )
    fun `곱셈 연산 정상 수행 확인`(input: String, expected: String) {
        commonTest(input, expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1 / 0, 0",
        "2 / 1, 2",
        "3 / 2 / 1, 1",
        "12 / 4 / 3 / 2, 0"
    )
    fun `나눗셈 연산 정상 수행 확인`(input: String, expected: String) {
        commonTest(input, expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1 + 2 * 3 / 4, 2",
        "1 / 0 * 3 + 4 - 5, -1",
        "5 / 4 * 3 * 3 / 1, 9",
        "10 - 2 - 3 * 5 * 5 / 3 + 2, 43"
    )
    fun `사칙 연산 정상 수행 확인`(input: String, expected: String) {
        commonTest(input, expected)
    }


    private fun commonTest(input: String, expected: String) {
        // given
        val tokenizedInutList = Tokenizer.tokenize(input)

        // when
        val stringCalculator = StringCalculator.create(tokenizedInutList)

        // then
        assertEquals(expected, stringCalculator.calculate())
    }
}
