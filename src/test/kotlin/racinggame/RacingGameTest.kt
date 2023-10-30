package racinggame

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

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
                        playResult.position shouldBe 1
                    }
                }
            }
        }
        When("2번 시도의 4이상의 숫자가 나온 경우") {
            val tryCount = 2

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
                result.racingResult.forEachIndexed { index, racingResult ->
                    if (index == 0) {
                        racingResult.result.forEach { playResult ->
                            playResult.position shouldBe 1
                        }
                    }
                    if (index == 1) {
                        racingResult.result.forEach { playResult ->
                            playResult.position shouldBe 2
                        }
                    }
                }
            }
        }

        When("경기가 끝난 후 우승자를 확인하는 경우") {
            val tryCount = 2
            val game = RacingGame(
                listOf(
                    Car("name1", 1),
                    Car("name2", 2)
                ),
                tryCount,
                ForwardDice()
            )
            val winners = game.getWinners()
            Then("더 많이간 자동차가 우승자가 되어야 한다") {
                winners.winners.map { it.name } shouldContainAll listOf("name2")
            }
        }
    }
})
