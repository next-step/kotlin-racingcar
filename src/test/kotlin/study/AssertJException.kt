package study

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class AssertJException {
    @Test
    fun `3 With AssertJ Using assertThatThrownBy`() {
        assertThatThrownBy {
            val list: List<String> = listOf("String one", "String two")
            list[2]
        }.isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessageContaining("Index 2 out of bounds for length 2")
    }
}
