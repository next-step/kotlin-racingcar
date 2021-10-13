package study.caculator.data

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class TextReaderTest {

    private lateinit var textReader: TextReader

    @BeforeEach
    internal fun setUp() {
        textReader = TextReader()
    }

    @Test
    fun `주어진 문자를 입력받으면 목록으로 반환한다`() {
        // given
        val givenText = "2 + 3"

        assertThat(textReader.parseText(givenText)).containsExactly("2", "+", "3")
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `주어진 문자가 공백이면 예외를 던진다`(givenText: String?) {
        assertThatCode { textReader.parseText(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `수식이 아닌 문자가 들어가면 예외를 던진다`() {
        val givenText = "2 ? 3"
        // when
        assertThatCode { textReader.parseText(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
