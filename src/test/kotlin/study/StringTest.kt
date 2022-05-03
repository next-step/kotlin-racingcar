package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun isEmpty(){
        assertThat("".isEmpty()).isTrue
        assertThat(" ".isEmpty()).isFalse
        assertThat("a".isEmpty()).isFalse
    }

    @Test
    fun isBlank(){
        assertThat("".isBlank()).isTrue
        assertThat(" ".isBlank()).isTrue
        assertThat("a".isBlank()).isFalse
    }

    @Test
    fun string(){
        assertThat("json"[0]).isEqualTo('j')
        assertThat("json"[1]).isEqualTo('s')
        assertThat("json"[2]).isEqualTo('o')
    }
}
