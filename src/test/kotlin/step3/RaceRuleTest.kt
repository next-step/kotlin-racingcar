package step3

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RaceRuleTest() {
    private val raceRule = RaceRule()

    @Test
    fun `4가 나오면 전진`() {
        raceRule.isGo(RaceNumber.from(4)) shouldBe true
    }

    @Test
    fun `4가 아닐때는 전진 안함`() {
        raceRule.isGo(RaceNumber.from(5)) shouldBe false
    }
}
