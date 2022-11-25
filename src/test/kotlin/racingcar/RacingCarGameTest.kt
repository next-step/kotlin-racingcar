package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.CarInfo
import racingcar.domain.GameInfo
import racingcar.domain.RacingCarGame

class RacingCarGameTest : BehaviorSpec({

    Given("3개의 자동차 정보를 받고") {
        val gameInfo = GameInfo(
            carInfo = CarInfo(
                names = listOf("pobi", "crong", "honux"),
                count = 3
            ),
            trialCount = 3
        )
        When("게임을 시작하면") {
            val game = RacingCarGame(gameInfo)
            Then("3개의 자동차가 생성된다.") {
                game.cars.size shouldBe 3
            }
        }
    }
})
