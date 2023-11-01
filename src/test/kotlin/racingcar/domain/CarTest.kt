package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    Given("자동차 객체는") {
        val car = Car("테스트")
        When("앞으로 전진할 수 있으며") {
            car.moveForward()
            Then("내부 필드인 전진 횟수를 증가한다.") {
                car.position shouldBe 1
            }
        }
    }
})
