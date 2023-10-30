package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class RacingCarGameTest : BehaviorSpec({

    Given("자동차 경주 게임은") {
        val racingCars = createRacingCars()
        When("처음 시작하면") {
            val racingCarGame = RacingCarGame.init(racingCars)
            Then("레이서의 수만큼 레이서가 만들어진다.") {
                racingCarGame.racingCars.count() shouldBe racingCars.count()
            }
        }
    }

    Given("자동차 경주 게임이 한 차례 진행되면") {
        val racingCarGame = RacingCarGame.init(createRacingCars())
        When("모든 플레이어들은 4 이상이 나오면") {
            racingCarGame.race { 4 }
            Then("전진한다.") {
                racingCarGame.racingCars.shouldForAll {
                    it.count shouldBe 1
                }
            }
        }
    }

    Given("자동차 경주 게임에서") {
        val racingCarGame = RacingCarGame.init(createRacingCars())
        When("모든 플레이어들은 4 미만이 나오면") {
            racingCarGame.race { 3 }
            Then("정지한다.") {
                racingCarGame.racingCars.shouldForAll {
                    it.count shouldBe 0
                }
            }
        }
    }

    Given("자동차 경주가 종료되면") {
        val racingCarGame =
            RacingCarGame.init(listOf(RacingCar("pobi", 3), RacingCar("crong", 2), RacingCar("honux", 1)))
        When("가장 높은 count를 가진 자동차가") {
            val winners = racingCarGame.calculateWinners()
            Then("우승한다.") {
                winners.get(0).name shouldBe "pobi"
            }
        }
    }

    Given("자동차 경주가 종료되었을 때") {
        val racingCarGame =
            RacingCarGame.init(listOf(RacingCar("pobi", 3), RacingCar("crong", 3), RacingCar("honux", 3)))
        When("가장 높은 count를 가진 자동차가 여러명이면") {
            val winners = racingCarGame.calculateWinners()
            Then("공동 우승한다.") {
                winners shouldHaveSize 3
            }
        }
    }
})

private fun createRacingCars() = listOf(RacingCar("pobi"), RacingCar("crong"), RacingCar("honux"))
