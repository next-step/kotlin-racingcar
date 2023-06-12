package study.racinggame.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("차 위치 기본값은 0이다") {
        val car = Car(name = "basic")
        `when`("차가 이동할 때 값이 위치 값이 1 증가한다.") {
            val oldPosition = car.position
            car.move(true)
            then("위치 값은 기존 값 보다 1증가한다.") {
                oldPosition shouldBe 1
                car.position shouldBe oldPosition + 1
            }
        }
    }
})
