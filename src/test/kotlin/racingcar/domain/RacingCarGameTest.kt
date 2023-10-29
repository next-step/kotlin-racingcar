package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.shouldBe

class RacingCarGameTest : BehaviorSpec({

    Given("자동차 경주 게임은") {
        val racers = listOf(Racer(), Racer(), Racer())
        When("처음 시작하면") {
            val racingCarGame = RacingCarGame.init(racers)
            Then("레이서의 수만큼 레이서가 만들어진다.") {
                racingCarGame.racers.count() shouldBe racers.count()
            }
        }
    }

    Given("자동차 경주 게임이 한 차례 진행되면") {
        val racingCarGame = RacingCarGame.init(listOf(Racer(), Racer(), Racer()))
        When("모든 플레이어들은") {
            Then("4 이상이 나오면 전진한다.") {
                val nextRacingCarGame = racingCarGame.race { 4 }
                nextRacingCarGame.racers.shouldForAll {
                    it.count shouldBe 1
                }
            }
        }
    }

    Given("자동차 경주 게임에서") {
        val racingCarGame = RacingCarGame.init(listOf(Racer(), Racer(), Racer()))
        When("모든 플레이어들은") {
            Then("4 미만이 나오면 정지한다.") {
                val nextRacingCarGame = racingCarGame.race { 3 }
                nextRacingCarGame.racers.shouldForAll {
                    it.count shouldBe 0
                }
            }
        }
    }
})
