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
    }

    @Test
    fun string() {
        assertThat("kihun"[0]).isEqualTo('k')
        assertThat("kihun"[1]).isEqualTo('i')
        assertThat("kihun"[2]).isEqualTo('h')
    }
}
