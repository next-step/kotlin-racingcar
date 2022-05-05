package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue
        assertThat(" ".isEmpty()).isFalse
    }

    @Test
    fun isBlank() {
        assertThat("".isBlank()).isTrue
        assertThat(" ".isBlank()).isTrue
        assertThat("\r\n".isBlank()).isTrue
        assertThat("\t".isBlank()).isTrue
    }

    @Test
    internal fun string() {
        assertThat("jason"[0]).isEqualTo('j')
        assertThat("jason"[1]).isEqualTo('a')
        assertThat("jason"[2]).isEqualTo('s')
        assertThat("jason"[3]).isEqualTo('o')
        assertThat("jason"[4]).isEqualTo('n')
    }

    @Test
    fun `spilt() 학습테스트`() {
        val normalString = "분리가 어떻게 될까요?"
        assertThat(normalString.split(" ").size).isEqualTo(3)

        val lastWordIsSpaceString = "마지막 문구가 공백이라면? "
        assertThat(lastWordIsSpaceString.split(" ").size).isEqualTo(4)
        assertThat(lastWordIsSpaceString.split(" ").last()).isEqualTo("")

        val firstWordIsSpaceString = " 첫번째 문구가 공백이라면?"
        assertThat(firstWordIsSpaceString.split(" ").size).isEqualTo(4)
        assertThat(firstWordIsSpaceString.split(" ").first()).isEqualTo("")

        val emptyString = "" //공백일때 나누면 몇개일까?
        assertThat(emptyString.split(" ").size).isEqualTo(1)

        val nullString: String? = null //null을 split하면 몇개일까?
        assertThat(nullString?.split(" ")?.size).isEqualTo(null)

        val doubleSpaceString = "공백이  두개가 들어간다면?"
        assertThat(doubleSpaceString.split(" ").size).isEqualTo(4)
        assertThat(doubleSpaceString.split(" ")[0]).isEqualTo("공백이")
        assertThat(doubleSpaceString.split(" ")[1]).isEqualTo("")
        assertThat(doubleSpaceString.split(" ")[2]).isEqualTo("두개가")
        assertThat(doubleSpaceString.split(" ")[3]).isEqualTo("들어간다면?")
    }
}