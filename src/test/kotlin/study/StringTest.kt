package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        // 이게 `True`인지 검증하라.
        assertThat("".isEmpty()).isTrue()
        // 이게 `false`인지 검증하라.
        assertThat("   ".isEmpty()).isFalse()
    }

    @Test
    fun isBlank() {
        assertThat("2".isBlank()).isFalse()
    }
}
