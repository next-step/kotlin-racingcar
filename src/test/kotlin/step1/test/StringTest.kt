package step1.test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    internal fun `이름`() {
        // allSatisfy
    }

    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue
        assertThat("a".isEmpty()).isFalse
        assertThat(" ".isBlank()).isTrue
    }

    @Test
    fun isBlank() {
        assertThat(" ".isBlank()).isTrue
        assertThat("".isBlank()).isTrue
        assertThat("\r\n".isBlank()).isTrue
        assertThat("\t".isBlank()).isTrue
    }
}
