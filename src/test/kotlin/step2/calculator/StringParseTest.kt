package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.calculator.utils.CustomStringParser

class StringParseTest {
    @Test
    fun `문자열을 " " 기준으로 나눈다`() {
        val string1 = "step1/test"
        val string2 = "입력 문자열"
        val string3 = "2+ 5"

        assertThat(CustomStringParser.splitAsWords(string1).size).isEqualTo(1)
        assertThat(CustomStringParser.splitAsWords(string2).size).isEqualTo(2)
        assertThat(CustomStringParser.splitAsWords(string3).size).isEqualTo(2)
    }

    @Test
    fun `입력값이 null이면 exception을 발생시킨다`() {
        assertThatThrownBy {
            CustomStringParser.splitAsWords(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "\t", "\r\t", "\r\n\t"])
    fun `빈 문자열이면 exception을 발생시킨다`(str: String?) {
        assertThatThrownBy {
            CustomStringParser.splitAsWords(str)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `빈 문자열을 제거한다`() {
        val testList1 = listOf("\t\n")
        val testList2 = listOf("2", "", "10")
        val testList3 = listOf("2", "3", " ")

        assertThat(CustomStringParser.removeEmptyStrings(testList1)).isEqualTo(listOf<String>())
        assertThat(CustomStringParser.removeEmptyStrings(testList2)).isEqualTo(listOf("2", "10"))
        assertThat(CustomStringParser.removeEmptyStrings(testList3)).isEqualTo(listOf("2", "3"))
    }
}
