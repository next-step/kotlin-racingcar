package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.Car

class StudyTest {
    @Test
    fun `string isBlank test`() {
        assertThat("".isBlank()).isTrue()
        assertThat(null?.isBlank()).isNull()
        assertThat(" ".isBlank()).isTrue()
    }

    @Test
    fun `for loop until test`() {
        val list = listOf("a", "b", "c", "d")
        for (i in 1 until list.size) {
            assertThat(i).isLessThan(list.size)
        }
    }

    @Test
    fun `assertion isBetween`() {
        assertThat(1).isBetween(1, 1)
    }

    @Test
    fun `nullable test`() {
        assertThat(null?.toInt()).isNull()
    }

    @Test
    fun `empty list joinToString`() {
        val list = emptyList<Car>()
        assertThat(list.joinToString(", ") { it.name.value }).isEqualTo("")
    }
}
