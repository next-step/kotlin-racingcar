package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    private val stringCalculator = StringCalculator(
        parser = StringCalculatorInputParser(),
        calculator = Calculator()
    )

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 10",
        "2 + 2 + 2 + 2, 8",
        "2 * 2 * 2 * 2, 16",
        "2 + 2 / 2 - 1, 1",
        "0.1 + 0.2 + 0.3, 0.6",
        "1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10, 55",
        "2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2, 1024",
        "3 * 2 + 1 / 2, 3.5",
        "5 - 2 - 1 + 3 / 5, 1"
    )
    fun `check calculated result`(input: String, expected: String) {
        val actual = stringCalculator.calculate(input)

        actual shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "null"])
    fun `Invalid input`(testValue: String?) {
        shouldThrow<IllegalArgumentException> {
            val input = if (testValue.equals("null")) null else testValue
            stringCalculator.calculate(input)
        }
    }
}
