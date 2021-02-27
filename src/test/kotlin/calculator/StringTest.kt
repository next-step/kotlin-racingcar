package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringTest {
    @Test
    fun name() {
        val string = "1 +2"
        assertThat(string.split(" ").size).isEqualTo(2)
    }

    @Test
    fun test2() {
        val string = "1 + 2"
        assertThat(string.split(" ").size).isEqualTo(3)
        assertThat(string.split("").size).isEqualTo(7)

        assertThat(string.replace(" ", "")).isEqualTo("1+2")
    }

    @Test
    fun test3() {
        val string = "1+2!@as"
        val regex = Regex("[^\\d+\\-*/]")

        assertThat(string.replace("[^\\d+\\-*/]".toRegex(), "")).isEqualTo("1+2")
    }
}
