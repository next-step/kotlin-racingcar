package study.racingcar.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingResultKoTest : StringSpec({
    "RacingResult를 통해 모든 라운드 결과와 승자들을 알 수 있다" {
        val winners = listOf(
            Record("그렌저", 2),
            Record("소나타", 2)
        )

        val rounds = listOf(winners)
        val racingResult = RacingResult(rounds)

        racingResult.rounds shouldBe rounds
        racingResult.winners() shouldBe winners
    }
})
