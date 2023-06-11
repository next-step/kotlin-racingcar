package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

internal class CarTest : BehaviorSpec({

    Given("Car") {
        val car = Car(lineNumber = 0)
        val previousPosition = car.position

        When("drive 성공 시") {
            val carRandomGenerator = mockk<CarRandomGenerator>()
            every { carRandomGenerator.canGo() } returns true
            car.drive()

            Then("position 1 증가") {
                car.position shouldBe previousPosition + 1
            }
        }
    }
})
