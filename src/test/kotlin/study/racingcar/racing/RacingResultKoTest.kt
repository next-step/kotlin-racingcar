package study.racingcar.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingResultKoTest : StringSpec({
    "기본 인자" {
        val winners = listOf(
            Record("그렌저", 2),
            Record("소나타", 2)
        )

        val rounds = listOf(winners)
        val racingResult = RacingResult(rounds)

        racingResult.rounds shouldBe rounds
        racingResult.getWinners() shouldBe winners
    }
})
