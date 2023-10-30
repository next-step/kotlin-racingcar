package racinggame

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual

class RacingGameTest : BehaviorSpec({

    Given("자동차 게임 시작") {
        When("1번 시도의 4이상의 숫자가 나온 경우") {
            val tryCount = 1

            val game = RacingGame(
                listOf(
                    Car("name1"),
                    Car("name2")
                ),
                tryCount,
                ForwardDice()
            )
            val result = game.play()
            Then("모든 자동차가 앞으로 움직여야 한다") {
                result.racingResult.forEach {
                    it.result.forEach { playResult ->
                        playResult shouldBeGreaterThanOrEqual 1
                    }
                }
            }
        }
    }
})
