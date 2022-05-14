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
        assertThat("dd.kim"[0]).isEqualTo('d')
        assertThat("dd.kim"[1]).isEqualTo('d')
        assertThat("dd.kim"[2]).isEqualTo('.')
        assertThat("dd.kim"[3]).isEqualTo('k')
        assertThat("dd.kim"[4]).isEqualTo('i')
        assertThat("dd.kim"[5]).isEqualTo('m')
    }
}
