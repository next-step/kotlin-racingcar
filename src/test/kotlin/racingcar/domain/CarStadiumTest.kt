package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.util.Message

class CarStadiumTest : BehaviorSpec({

    Given("자동차의 대수와 전진 시도 횟수가 정수로 주어지고") {
        val numberOfCars = 5
        val numberOfTrials = 3
        When("게임을 시작한다면") {
            val gameResult = CarStadium(numberOfCars, numberOfTrials).gameStart()
            Then("게임 결과를 문자열로 반환한다.") {
                gameResult.contains(Message.RACE_RESULT_FIRST_LINE.message) shouldBe true
            }
        }
    }
})
