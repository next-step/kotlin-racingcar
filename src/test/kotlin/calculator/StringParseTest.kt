package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import utils.CustomStringParser

class StringParseTest {
    @Test
    fun `문자열을 " " 기준으로 나눈다`() {
        val string1 = "test"
        val string2 = "입력 문자열"
        val string3 = "2+ 5"

        assertThat(CustomStringParser.parse(string1).size).isEqualTo(1)
        assertThat(CustomStringParser.parse(string2).size).isEqualTo(2)
        assertThat(CustomStringParser.parse(string3).size).isEqualTo(2)
    }

    @Test
    fun `입력값이 null이면 exception을 발생시킨다`() {
        assertThatThrownBy {
            CustomStringParser.parse(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "\t", "\r\t", "\r\n\t"])
    fun `빈 문자열이면 exception을 발생시킨다`(str: String?) {
        assertThatThrownBy {
            CustomStringParser.parse(str)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}