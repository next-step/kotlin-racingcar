package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StudyTest {
    @Test
    fun `string isBlank test`() {
        assertThat("".isBlank()).isTrue()
        assertThat(null?.isBlank()).isNull()
        assertThat(" ".isBlank()).isTrue()
    }

    @Test
    fun test() {
        val list = listOf("a", "b", "c", "d")
        for (i in 1 until list.size) {
            println(list[i])
        }
    }
}
