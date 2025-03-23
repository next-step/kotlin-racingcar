package racingcar.car

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CarsTest : ShouldSpec({
    context("MoveAll") {
        should("move all cars") {
            val cars =
                Cars(
                    listOf(
                        Car(canMove = { true }),
                        Car(canMove = { true }),
                    ),
                )

            cars.moveAll()

            cars.getPositions() shouldBe listOf(1, 1)
        }
    }
})
