package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCountTest {

    @Test
    fun `count 함수`() {
        val count = "a,b,c".count { it == ',' }
        assertThat(count).isEqualTo(2)
    }
}
