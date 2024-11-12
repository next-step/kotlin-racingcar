package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        val actual = "".isEmpty()
        println("isBlank actual:$actual")
        assertThat("\n".isBlank()).isEqualTo(true)
    }
}
