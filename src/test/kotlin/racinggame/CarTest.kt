package racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.Car
import racinggame.domain.DiceResult

class CarTest : BehaviorSpec({

    Given("자동차가 주어졌다") {
        val car = Car("baek")
        When("앞으로 가야할 경우") {
            val originPosition = car.position
            car.move(DiceResult.FORWARD)
            Then("1칸 앞으로 이동 해야 한다") {
                car.position shouldBe originPosition + 1
            }
        }
    }

    Given("자동차를 인스턴스화 한다") {
        When("자동차 이름이 5자가 넘는 경우") {
            Then("에러가 발생해야한다") {
                shouldThrow<IllegalArgumentException> {
                    Car("name123")
                }
            }
        }
    }
})
