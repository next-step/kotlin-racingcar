package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun `isNullOrEmpty`() {
        assertThat("".isNullOrEmpty()).isTrue
        assertThat(" ".isNullOrEmpty()).isFalse

        val input : String? = null
        assertThat(input.isNullOrEmpty()).isTrue
    }

    @Test
    fun `isNullOrBlank`() {
        assertThat("".isNullOrBlank()).isTrue
        assertThat(" ".isNullOrBlank()).isTrue

        val input : String? = null
        assertThat(input.isNullOrBlank()).isTrue
    }
}