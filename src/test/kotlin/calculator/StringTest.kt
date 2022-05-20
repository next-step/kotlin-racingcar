package calculator

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
    }
}
