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
    internal fun isBlank() {
        assertThat("".isBlank()).isTrue()
        assertThat(" ".isBlank()).isTrue()
        assertThat("  ".isBlank()).isTrue()
        assertThat("a".isBlank()).isFalse()
        assertThat(" a".isBlank()).isFalse()
        assertThat("a ".isBlank()).isFalse()
        assertThat("\r\n".isBlank()).isTrue()
        assertThat("\r".isBlank()).isTrue()
        assertThat("\n".isBlank()).isTrue()
        assertThat("\t".isBlank()).isTrue()
    }
}