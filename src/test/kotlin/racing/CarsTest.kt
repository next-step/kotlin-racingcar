package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({
    "자동차들이 자동차 수에 맞게 생성된다" {
        val cars = Cars.of(carCount = 3)

        cars.cars shouldHaveSize 3
    }

    "자동차들이 경주하면 모든 자동차가 움직인다" {
        val cars = Cars.of(carCount = 3)

        cars.play(movePolicy = { true })

        for (car in cars.cars) {
            car.position shouldBe 1
        }
    }
})
