package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArrayTest {
    @Test
    fun arrayTest() {
        // given
        val values: ArrayList<String> = ArrayList()
        values.add("first")
        values.add("second")

        assertThat(values.add("third")).isTrue
        assertThat(values.size).isEqualTo(3)
        assertThat(values[0]).isEqualTo("first")
        assertThat(values.contains("first")).isTrue
        assertThat(values.removeAt(0)).isEqualTo("first")
        assertThat(values.size).isEqualTo(2)
    }
}
