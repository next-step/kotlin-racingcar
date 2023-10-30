package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import racingcar.util.Message
import racingcar.util.Message.*

class CarStadiumTest : BehaviorSpec({
    val fourOrMoreGenerator = object: RandomGenerator<Int>(4, 9) {
        override fun generate(start: Int, end: Int): Int =
            IntRange(start, end).random()
    }
    val underFourGenerator = object: RandomGenerator<Int>(0, 3) {
        override fun generate(start: Int, end: Int): Int =
            IntRange(start, end).random()
    }

    Given("자동차의 대수와 전진 시도 횟수가 정수로 주어지고") {
        val numberOfCars = 5
        val numberOfTrials = 3
        When("항상 전진할 수 있는 게임을 시작한다면") {
            val result = CarStadium(
                numberOfCars,
                numberOfTrials,
                CarMove(fourOrMoreGenerator)
            ).gameStart()
            Then("시도 횟수만큼 결과 리스트를 반환하며 매 라운드마다 전진한다.") {
                val histories = result.getRacingHistories()
                histories.size shouldBe numberOfTrials

                histories.forEachIndexed { index, racingHistories ->
                    racingHistories.all { CAR_RACING_MOVING_SYMBOL.message.repeat(it.move) == CAR_RACING_MOVING_SYMBOL.message.repeat(index + 1)} shouldBe true
                }
            }
        }

        When("항상 전진할 수 없는 게임을 시작한다면") {
            val result = CarStadium(
                numberOfCars,
                numberOfTrials,
                CarMove(underFourGenerator)
            ).gameStart()
            Then("시도 횟수만큼 결과 리스트를 반환하며 전진 횟수는 항상 0이다.") {
                val histories = result.getRacingHistories()
                histories.size shouldBe numberOfTrials

                histories.forEach { racingHistories ->
                    racingHistories.all { CAR_RACING_MOVING_SYMBOL.message.repeat(it.move) == CAR_RACING_MOVING_SYMBOL.message.repeat(0)} shouldBe true
                }
            }
        }
    }

})
