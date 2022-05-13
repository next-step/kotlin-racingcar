package racingcar.view.input.parser

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class CarNamesInputParserTest {
    @Test
    internal fun testForOverLength() {

        val maxLengthOfName = 5
        val inputParser = CarNamesInputParser(maxLengthOfName = maxLengthOfName)

        Assertions.assertThatThrownBy {
            inputParser.parseValue("a, 5isOk, 6isNot, def, 7isNot2, jtkim")
        }.hasMessageFindingMatch("길이 > $maxLengthOfName(.)*6isNot,7isNot2")
    }

    @Test
    internal fun testForEmptyCase() {

        val maxLengthOfName = 5
        val inputParser = CarNamesInputParser(maxLengthOfName = maxLengthOfName)

        Assertions.assertThatThrownBy {
            inputParser.parseValue(" ,  ,  ,  ,  ,  ")
        }.hasMessageFindingMatch("잘못된 이름")
    }

    @Test
    internal fun testForNormalCase() {

        // given
        val maxLengthOfName = 5
        val inputParser = CarNamesInputParser(maxLengthOfName = maxLengthOfName)

        // when
        val result = inputParser.parseValue(" abc,  ,def  , ghi ,  ,  ")

        // then
        assertAll(
            { assertThat(result.count()).isEqualTo(3) },
            { assertThat(result.joinToString(",")).isEqualTo("abc,def,ghi") }
        )
    }
}
