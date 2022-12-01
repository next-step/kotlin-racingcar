package study.racingcar.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingResultKoTest : StringSpec({
    "RacingResult를 통해 라운드 결과를 알 수 있다" {
        val rounds = listOf(
            listOf(
                Record("그렌저", 2),
                Record("소나타", 2)
            ),
            listOf(
                Record("그렌저", 3),
                Record("소나타", 2)
            )
        )

        val racingResult = RacingResult(rounds)

        racingResult.rounds shouldBe rounds
    }
})
