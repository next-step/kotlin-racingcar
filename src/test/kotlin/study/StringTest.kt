package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        Assertions.assertThat("".isEmpty()).isTrue()
    }
}
