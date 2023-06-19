package stringCalculatorTest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringCalculator.StringParser
import stringCalculator.StringType
import java.lang.NumberFormatException

class StringParserTest {
    @ParameterizedTest
    @CsvSource(
        "10, NUMBER",
        "*, OPERATOR"
    )
    fun parseStringTest(input: String, expected: StringType) {
        val result = StringParser.parseString(input)
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun numberFormatExceptionTest() {
        Assertions.assertThrows(NumberFormatException::class.java) {
            StringParser.parseString("45.11")
        }
    }
}
