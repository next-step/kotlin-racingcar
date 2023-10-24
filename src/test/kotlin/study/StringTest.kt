package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue
        assertThat("     ".isEmpty()).isFalse
    }

    @Test
    fun isBlank() {
        assertThat("".isBlank()).isTrue
        assertThat("     ".isBlank()).isTrue
        assertThat("\n".isBlank()).isTrue
        assertThat("""\n """"".isBlank()).isFalse
    }
}
