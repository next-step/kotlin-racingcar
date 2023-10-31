package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    var car = Car()

    given("Car 가") {
        `when`("RadomInt 가 4 보다 작을 때에는") {
            car.moveForward(3)
            then("정지") {
                car.currentPosition shouldBe 1
            }
        }

        `when`("RandomInt 가 4 이상일 때에는") {
            car.moveForward(5)
            then("전진") {
                car.currentPosition shouldBe 2
            }
        }
    }
})
