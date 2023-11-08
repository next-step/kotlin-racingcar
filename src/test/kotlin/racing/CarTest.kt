package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    given("각 자동차는 랜덤값에 따라서 전진") {
        `when`("랜덤값이 4이상이면 자동차가 전진") {
            val cars = RaceExecutor.prepareCar(3)

            for (car in cars) {
                car.moveOrNot() { 5 }
            }
            cars[1].position shouldBe "-"
        }

        `when`("랜덤값이 4미만이면 자동차는 멈춤") {
            val cars = RaceExecutor.prepareCar(3)

            for (car in cars) {
                car.moveOrNot() { 3 }
            }
            cars[1].position shouldBe ""
        }
    }
})
