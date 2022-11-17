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

    "승자는 단수일 수 있다" {
        val rounds = listOf(
            listOf(
                Record("그렌저", 3),
                Record("소나타", 2)
            )
        )

        val winners = listOf(Record("그렌저", 3))
        val racingResult = RacingResult(rounds)

        racingResult.winners() shouldBe winners
    }

    "승자는 복수일 수 있다" {
        val winners = listOf(
            Record("그렌저", 3),
            Record("소나타", 3)
        )
        val rounds = listOf(winners)
        val racingResult = RacingResult(rounds)

        racingResult.winners() shouldBe winners
    }

    "자동차가 하나 뿐이면 승자도 해당 자동차 하나다" {
        val rounds = listOf(
            listOf(
                Record("그렌저", 3),
            )
        )

        val winners = listOf(Record("그렌저", 3))
        val racingResult = RacingResult(rounds)

        racingResult.winners() shouldBe winners
    }
})
