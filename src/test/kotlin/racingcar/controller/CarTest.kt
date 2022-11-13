package racingcar.controller

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({

    "after moving Car, can get current position" {
        val car = Car()
        car.move(1)
        car.move(3)
        car.move(4)

        car.currentPosition shouldBe 8
    }
})
