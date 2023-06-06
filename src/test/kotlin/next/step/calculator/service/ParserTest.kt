package next.step.calculator.service

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ParserTest {
    @Test
    fun `문자열을 공백 기준으로 분리하여 리스트 생성`() {
        Parser.parse("2 + 3 * 4 / 2") shouldBe listOf("2", "+", "3", "*", "4", "/", "2")
    }
}
