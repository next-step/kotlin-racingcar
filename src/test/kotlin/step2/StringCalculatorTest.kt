package step2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "2 + 3,5.0",
        "8 - 1,7.0",
        "3 * 4,12.0",
        "8 / 4,2.0"
    )
    fun `arithmetic operation test`(inputStr: String, expected: Double) {
        assertEquals(
            expected,
            StringCalculator()
                .append(inputStr)
                .result()
        )
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 10.0",
        "21 * 63 / 3 / 7 - 10, 53.0",
        "223 - 63 * 4 / 2, 320.0",
        "2123 - 10 + 50 / 4, 540.75"
    )
    fun `multiple operands test`(inputStr: String, expected: Double) {
        assertEquals(
            expected,
            StringCalculator()
                .append(inputStr)
                .result()
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["123 + 삼백", "123 + 3849 ^ 13"])
    fun `non-arithmetic operator or non-digit check test`(inputStr: String) {
        assertThrows(
            IllegalArgumentException::class.java,
            StringCalculator().append(inputStr)::result
        )
    }

    @ParameterizedTest
    @CsvSource(
        "2             + 3 * 4 / 2, 10.0",
        "2  1 * 6   3            / 3 / 7 - 10, 53.0",
        "223 - 63 * 4 / 2, 320.0",
        "2123 - 10 + 50 / 4, 540.75"
    )
    fun `blank remove test`(inputStr: String, expected: Double) {
        assertEquals(
            expected,
            StringCalculator()
                .append(inputStr)
                .result()
        )
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3, 8 - 1, 2+38-1",
        "3 * 4, + 8 / 4, 3*4+8/4"
    )
    fun `display sequential expression test`(
        inputStr1: String,
        inputStr2: String,
        expected: String
    ) {
        val calculator = StringCalculator()
        calculator
            .append(inputStr1)
            .append(inputStr2)

        assertEquals(expected, calculator.display())
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3, 8 - 1, 39.0",
        "3 * 4, + 8 / 4, 5.0"
    )
    fun `calculate sequential expression test 1`(
        inputStr1: String,
        inputStr2: String,
        expected: Double
    ) {
        val calculator = StringCalculator()
        calculator
            .append(inputStr1)
            .append(inputStr2)

        assertEquals(expected, calculator.result())
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3, 8 - 1",
        "3 * 4, + 8 / 4"
    )
    fun `clear test`(
        inputStr1: String,
        inputStr2: String
    ) {
        val calculator = StringCalculator()
        calculator
            .append(inputStr1)
            .append(inputStr2)
            .clear()
        assertEquals("", calculator.display())
    }
}