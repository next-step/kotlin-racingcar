package step3.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty

class DefaultCarTest : BehaviorSpec({
    given("차") {
        val car: Car = DefaultCar()
        then("차 객체 생성시 track은 비어있다") {
            car.getTrack().shouldBeEmpty()
        }
        `when`("차가 전진한다") {
            car.goForward()
            then("track이 한칸 이동한다") {
                car.getTrack() shouldBe ("-")
            }
        }
    }
})
