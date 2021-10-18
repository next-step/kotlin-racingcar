package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringUtilsTest {

    @Test
    fun `문자를 구분자를 전달하여 분리된 목록으로 리턴한다`() {
        val givenText = "a,b,c"
        val delimiter = ","

        val actual = splitText(givenText, delimiter)

        assertThat(actual).containsExactly("a", "b", "c")
    }

    @Test
    fun `빈 문자열을 전달하면 비어있는 목록을 리턴한다`() {
        val givenText = ""
        val delimiter = ","

        val actual = splitText(givenText, delimiter)

        assertThat(actual).containsExactly("")
    }
}
