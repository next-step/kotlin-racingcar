package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StringTest {
    @get:Test
    val isEmpty: Unit
        get() {
            Assertions.assertThat("".isEmpty()).isTrue
            Assertions.assertThat(" ".isEmpty()).isFalse
            Assertions.assertThat("a".isEmpty()).isFalse
        }

    @Test
    fun lastIndexOf() {
        Assertions.assertThat("abcde".lastIndexOf("b")).isEqualTo(1)
    }
}
