package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue()
        assertThat(" ".isEmpty()).isFalse()
        assertThat("a".isEmpty()).isFalse()
    }

    @Test
    fun isBlank() {
        assertThat("".isBlank()).isTrue()
        assertThat(" ".isBlank()).isTrue()
        assertThat("\r\n".isBlank()).isTrue()
        assertThat("\t".isBlank()).isTrue()
    }

    @Test
    fun string() {
        assertThat("jason"[0]).isEqualTo('j')
        assertThat("jason"[1]).isEqualTo('a')
        assertThat("jason"[2]).isEqualTo('s')
    }
}
