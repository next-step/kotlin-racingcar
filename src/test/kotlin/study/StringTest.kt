package study

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue
        assertThat("    ".isEmpty()).isFalse
        assertThat("a".isEmpty()).isFalse
        assertThat("\n".isEmpty()).isFalse
        assertThat("".isBlank()).isTrue
        assertThat("".isNotBlank()).isFalse
        assertThat(" \n".isBlank()).isTrue
    }
}
