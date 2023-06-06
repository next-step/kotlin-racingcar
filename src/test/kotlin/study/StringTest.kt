package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue()
        assertThat(" ".isEmpty()).isFalse()
    }

    @Test
    fun `문자를 찾아 마지막 위치를 반환한다`() {
        assertThat("abc".lastIndexOf("c")).isEqualTo(2)
        assertThat("abcabc".lastIndexOf("c")).isEqualTo(5)
    }

    @Test
    fun `문자열을 split 한다`() {
        assertThat("1,2".split(",")).containsExactly("1", "2")
    }
}
