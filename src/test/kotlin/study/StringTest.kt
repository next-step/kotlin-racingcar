package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun isEmpty() {
        //given
        //when
        //then
        assertThat("".isEmpty()).isTrue()
        assertThat(" ".isEmpty()).isFalse()
    }
}
