package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("\n".isBlank()).isTrue()
        assertThat(" ".isBlank()).isTrue()
        assertThat("\n".isBlank()).isTrue()
        assertThat(""""\n"""".isBlank()).isFalse()
    }
}
