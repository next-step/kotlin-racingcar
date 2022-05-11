package racingcar.view.input.parser

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class IntInputParserTest {
    @Test
    internal fun testForNotANumber() {
        val inputParser = IntInputParser()

        Assertions.assertThatThrownBy {
            inputParser.parseValue("test")
        }.hasMessageFindingMatch("숫자로")
    }

    @ParameterizedTest
    @CsvSource(
        "10,15,9", // "less than" case
        "20,30,40", // "greater than" case
        "0,300,-5" // "minus" case
    )
    internal fun testForRangeError(startOfRange: Int, endOfRange: Int, inputString: String) {
        val inputParser = IntInputParser(startOfRange..endOfRange)
        Assertions.assertThatThrownBy {
            inputParser.parseValue(inputString)
        }.hasMessageFindingMatch("$startOfRange ~ $endOfRange 사이 값")
    }

    @ParameterizedTest
    @CsvSource(
        "10,10", // equal case
        "10,8", // "less than" case
        "10,-100" // minus case
    )
    internal fun testForGreaterThanError(minInputValue: Int, inputString: String) {
        val inputParser = IntInputParser(greaterThan = minInputValue)
        Assertions.assertThatThrownBy {
            inputParser.parseValue(inputString)
        }.hasMessageFindingMatch("$minInputValue 보다 큰")
    }

    @ParameterizedTest
    @CsvSource(
        "10,15,12", // "middle value" case
        "100,150,100", // "min value" case
        "200,300,300" // "max value" case
    )
    internal fun testForRangeOk(startOfRange: Int, endOfRange: Int, inputString: String) {
        val expected = inputString.toInt()
        val inputParser = IntInputParser(startOfRange..endOfRange)
        assertThat(inputParser.parseValue(inputString)).isEqualTo(expected)
    }

    @Test
    internal fun testForGreaterThanOk() {
        val minInputValue = 100
        val inputString = "101"
        val expected = 101

        val inputParser = IntInputParser(greaterThan = minInputValue)
        assertThat(inputParser.parseValue(inputString)).isEqualTo(expected)
    }
}
