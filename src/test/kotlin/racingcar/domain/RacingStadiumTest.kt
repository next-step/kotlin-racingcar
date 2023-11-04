package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.Racing

class RacingStadiumTest : BehaviorSpec({
    val intRandomGenerator = { start: Int, end: Int -> IntRange(start, end).random() }
    val alwaysForward = MovingCondition(5, 9, Racing.MOVE_FORWARD_CONDITION)
    val cantMove = MovingCondition(0, 3, Racing.MOVE_FORWARD_CONDITION)

    Given("자동차 경주 선수들이 존재하고") {
        val racingPlayers = RacingPlayers.of("a,b,c")

        When("항상 전진할 수 있는 게임을 시작한다면") {
            val result = RacingStadium(
                racingPlayers,
                RandomRacingRule(intRandomGenerator, alwaysForward)
            ).gameStart(3)
            Then("시도 횟수만큼 결과 리스트를 반환하며 매 라운드마다 전진한다.") {
                val histories = result.allRounds
                histories.size shouldBe 3
                histories.forEachIndexed { index, racingHistories ->
                    racingHistories.all { it.move == index + 1 } shouldBe true
                }
            }
        }

        When("항상 전진할 수 없는 게임을 시작한다면") {
            val result = RacingStadium(
                racingPlayers,
                RandomRacingRule(intRandomGenerator, cantMove)
            ).gameStart(3)
            Then("시도 횟수만큼 결과 리스트를 반환하며 전진 횟수는 항상 0이다.") {
                val histories = result.allRounds
                histories.size shouldBe 3

                histories.forEach { racingHistories ->
                    racingHistories.all { it.move == 0 } shouldBe true
                }
            }
        }
    }
})
