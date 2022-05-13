package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {
    @Test
    fun `string parse`() {
        val stringList = listOf<String>(
            "1.1 + 12 + 3 / 4",
            "1.1+12+3/4",
            " 1.1         + 1 2 + 3 / 4 ",
            " 1 . 1         + 1 2 + 3 / 4 ",
        )
        val list = listOf<String>("1.1", "+", "12", "+", "3", "/", "4")
        stringList.forEach { str: String -> assertThat(StringParser.parse(str) == list).isTrue }
    }

    @Test
    fun `assertThatThrownBy example`() {
        val list = listOf("0", "1", "2")
        val size = list.size
        val index = 9
        assertThatThrownBy { list[index] }.hasMessageMatching("Index $index out of bounds for length $size")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `empty error`(string: String) {
        assertThatThrownBy {
            StringParser.parse(string)
        }.hasMessageContaining(StringParser.emptyMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+2a", "잘못된 입력"])
    fun `input error`(string: String) {
        assertThatThrownBy {
            StringParser.parse(string)
        }.hasMessageContaining(StringParser.errorMessage)
    }
}
