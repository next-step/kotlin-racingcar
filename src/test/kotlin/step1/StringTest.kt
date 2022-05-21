package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun isBlank() {
        assertThat("".isBlank()).isTrue
    }

    @Test
    fun string() {
        assertThat("jason"[0]).isEqualTo('j')
        assertThat("jason"[1]).isEqualTo('a')
        assertThat("jason"[2]).isEqualTo('s')
        assertThat("jason"[3]).isEqualTo('o')
        assertThat("jason"[4]).isEqualTo('n')
    }
}
