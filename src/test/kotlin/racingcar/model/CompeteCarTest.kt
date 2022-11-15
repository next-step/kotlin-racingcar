package racingcar.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CompeteCarTest : BehaviorSpec({
    given("CompeteCar") {
        val car: Car = CompeteCar("Kim", DefaultCar())
        `when`("Kim Car가 전진하면") {
            val newCar = car.goForward()
            then("Kim Car의 track이 한칸 이동한다") {
                newCar.track shouldBe ("-")
                (newCar as Owner).name shouldBe ("Kim")
            }
        }
    }
})
