package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        assertThat("\n".isBlank()).isEqualTo(true)
    }
}
