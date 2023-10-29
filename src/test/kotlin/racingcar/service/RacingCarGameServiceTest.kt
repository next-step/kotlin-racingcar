package racingcar.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.shouldBe

class RacingCarGameServiceTest : BehaviorSpec({

    Given("자동차 경주 게임은") {
        val countOfRacer = 3
        val racingCarGameService = RacingCarGameService()
        When("처음 시작하면") {
            racingCarGameService.init(countOfRacer)
            Then("레이서의 수만큼 레이서가 만들어진다.") {
                racingCarGameService.racers.count() shouldBe countOfRacer
            }
        }
    }

    Given("자동차 경주 게임이 한 차례 진행되면") {
        val racingCarGameService = RacingCarGameService()
        racingCarGameService.init(3)
        When("모든 플레이어들은") {
            Then("4 이상이 나오면 전진한다.") {
                racingCarGameService.race { 4 }
                racingCarGameService.racers.shouldForAll {
                    it.count shouldBe 1
                }
            }
        }
    }

    Given("자동차 경주 게임에서") {
        val racingCarGameService = RacingCarGameService()
        racingCarGameService.init(3)
        When("모든 플레이어들은") {
            Then("4 미만이 나오면 정지한다.") {
                racingCarGameService.race { 3 }
                racingCarGameService.racers.shouldForAll {
                    it.count shouldBe 0
                }
            }
        }
    }
})
