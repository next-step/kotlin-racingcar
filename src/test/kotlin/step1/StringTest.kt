package step1

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
    fun lastIndexOf() {
        assertThat("abcde".lastIndexOf("b")).isEqualTo(1)
    }
}
