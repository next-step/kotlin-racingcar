package racingcar.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux"])
    fun `String 이 올바르게 파싱되는지 테스트 한다 콤마로 구분된다`(value: String) {
        assertThat(StringParser.parse(value)).isEqualTo(value.toString().split(","))
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux"])
    fun `parse의 return type 이 List 인지 확인한다`(value: String) {
        assertThat(StringParser.parse(value)).isInstanceOf(List::class.java)
    }
}
