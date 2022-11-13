package racingcar.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class DefaultCarTest : BehaviorSpec({
    given("차") {
        val car: Car = DefaultCar()
        `when`("차가 전진하면") {
            val newCar = car.goForward()
            then("track이 한칸 이동한다") {
                newCar.track shouldBe ("-")
            }
        }
    }
})
