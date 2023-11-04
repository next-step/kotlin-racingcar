package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingResult.RacingHistory

class RacingResultTest : BehaviorSpec({

    Given("자동차 경기 이력이 존재하고") {
        val firstRound = listOf(
            RacingHistory("a", 1),
            RacingHistory("b", 0),
            RacingHistory("c", 1),
        )
        val secondRound = listOf(
            RacingHistory("a", 2),
            RacingHistory("b", 1),
            RacingHistory("c", 2),
        )
        When("경기 결과의 우승자를 조회한다면") {
            val winners = RacingResult(listOf(firstRound, secondRound)).getRacingWinners()
            Then("가장 많이 움직인 자동차들을 반환한다.") {
                winners shouldBe listOf(
                    RacingWinner("a"),
                    RacingWinner("c")
                )
            }
        }
    }
})
