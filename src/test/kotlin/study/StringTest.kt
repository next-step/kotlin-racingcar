package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun `Join을 해보자`() {
        val listOf = listOf("A", "B")
        print(listOf.joinToString(","))
        assertThat(listOf.joinToString())
            .isEqualTo("A, B")
    }
}
