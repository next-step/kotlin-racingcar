package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.Car.ActionType

class CarTest : BehaviorSpec({

    Given("자동차의 액션 타입이 STOP일 때") {
        val car = Car(name = "yuuuzzzin")
        val actionType = ActionType.STOP
        When("액션을 취하면") {
            car.action(actionType)
            Then("전진하지 않는다.") {
                car.distance shouldBe 0
            }
        }
    }

    Given("자동차의 액션 타입이 GO일 때") {
        val car = Car(name = "yuuuzzzin")
        val actionType = ActionType.GO
        When("액션을 취하면") {
            car.action(actionType)
            Then("전진한다.") {
                car.distance shouldBe 1
            }
        }
    }
})
