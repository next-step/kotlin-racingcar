package calculator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class ParserTest {

    @Test
    fun `정상 공식은 정상적으로 파싱된다`() {
        val parser = Parser(3)

        val elements: List<String> = parser.parse("2 + 3 * 4 / 2")

        assertThat(elements).asList().isEqualTo(listOf("2", "+", "3", "*", "4", "/", "2"))
    }

    @Test
    fun `빈 공식`() {
        val parser = Parser(3)

        val elements: List<String> = parser.parse(" ")

        assertThat(elements).asList().isEqualTo(emptyList<String>())
    }

    @Test
    fun `빈 elements 인 경우 IllegalArgumentException throw`() {
        val parser = Parser(3)
        val elements: List<String> = listOf()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                parser.validate(elements)
            }
    }
}
