package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue
    }

    @Test
    fun isBlank() {
        assertThat(" ".isBlank()).isTrue
        assertThat("\r\r".isBlank()).isTrue
        assertThat("\r\r\n\t\t".isBlank()).isTrue
        assertThat("\r\r\n\n".isBlank()).isTrue
    }

    @Test
    fun string() {
        assertThat("Charming"[0]).isEqualTo('C')
    }
}
