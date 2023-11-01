package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.Racing
import racingcar.util.Message.*

class RacingStadiumTest : BehaviorSpec({
    val intRandomGenerator = { start: Int , end: Int -> IntRange(start, end).random() }
    val stubValidation = { _: List<String> -> true }
    val alwaysForward = RacingProperty(5,9, Racing.MOVE_FORWARD_CONDITION)
    val cantMove = RacingProperty(0,3, Racing.MOVE_FORWARD_CONDITION)

    Given("자동차의 대수와 전진 시도 횟수가 정수로 주어지고") {
        val nameOfCars = "a,b,c".split(",")
        val numberOfTrials = 3
        When("항상 전진할 수 있는 게임을 시작한다면") {
            val result = RacingStadium(
                nameOfCars,
                numberOfTrials,
                RacingRule(intRandomGenerator, stubValidation, alwaysForward)
            ).gameStart()
            Then("시도 횟수만큼 결과 리스트를 반환하며 매 라운드마다 전진한다.") {
                val histories = result.allRounds
                histories.size shouldBe numberOfTrials

                histories.forEachIndexed { index, racingHistories ->
                    racingHistories.all { CAR_RACING_MOVING_SYMBOL.message.repeat(it.move) == CAR_RACING_MOVING_SYMBOL.message.repeat(index + 1)} shouldBe true
                }
            }
        }

        When("항상 전진할 수 없는 게임을 시작한다면") {
            val result = RacingStadium(
                nameOfCars,
                numberOfTrials,
                RacingRule(intRandomGenerator, stubValidation, cantMove)
            ).gameStart()
            Then("시도 횟수만큼 결과 리스트를 반환하며 전진 횟수는 항상 0이다.") {
                val histories = result.allRounds
                histories.size shouldBe numberOfTrials

                histories.forEach { racingHistories ->
                    racingHistories.all { CAR_RACING_MOVING_SYMBOL.message.repeat(it.move) == CAR_RACING_MOVING_SYMBOL.message.repeat(0)} shouldBe true
                }
            }
        }
    }

})
