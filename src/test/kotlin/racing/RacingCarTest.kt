package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.car.RacingCar

class RacingCarTest : BehaviorSpec({
    val racingCar = RacingCar()

    Given("레이싱 자동차 준비") {
        val randomValue = 4

        When("랜덤 값이 4 이상인 경우에 자동차가 움직인다") {
            if (randomValue >= 4) {
                racingCar.move()
            }
        }

        Then("자동차의 위치는 0에서 움직여서 1이다") {
            racingCar.position shouldBe 1
        }
    }
})
