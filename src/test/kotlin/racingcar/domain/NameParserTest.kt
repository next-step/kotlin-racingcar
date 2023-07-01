package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NameParserTest {

    @Test
    fun `문자열을 받아 이름 목록을 반환한다`() {
        val parser = NameParser()

        val parsedNames = parser.parse("a,b,c")

        parsedNames shouldBe listOf("a", "b", "c")
    }

    @Test
    fun `공백을 전달하면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { NameParser().parse(" ") }
    }
}
