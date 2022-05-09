package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue
        assertThat(" ".isEmpty()).isFalse
        assertThat("a".isEmpty()).isFalse
    }

    @Test
    fun isBlank() {
        assertThat("".isBlank()).isTrue
        assertThat(" ".isBlank()).isTrue
        assertThat("\r\n".isBlank()).isTrue
        assertThat("\t".isBlank()).isTrue
    }

    @Test
    fun string() {
        assertThat("jason"[0]).isEqualTo('j')
    }

    @Test
    fun isNullOrBlank() {
        assertThat("".isNullOrBlank()).isTrue
        assertThat(" ".isNullOrBlank()).isTrue
        assertThat(null.isNullOrBlank()).isTrue
        assertThat(" a".isNullOrEmpty()).isFalse
    }

    @Test
    fun split() {
        assertThat("2 + 3".split(" ")[0]).isEqualTo("2")
        assertThat("2 + 3".split(" ")[1]).isEqualTo("+")
        assertThat("2 + 3".split(" ")[2]).isEqualTo("3")
    }
}
