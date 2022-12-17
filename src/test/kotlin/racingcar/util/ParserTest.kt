package racingcar.util

import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ParserTest {

    @DisplayName("스트링을 특정 구분자로 나눈다")
    @Test
    fun parse() {
        val elements: List<String> = Parser.parse("1,2,3", ",")

        assertThat(elements).asList().isEqualTo(listOf("1", "2", "3"))
    }

    @DisplayName("빈 스트링은 빈 리스트를 반환한다")
    @Test
    fun parseEmptyString() {
        val elements: List<String> = Parser.parse("", ",")

        elements shouldBe emptyList()
    }
}
