package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racingcar.domain.car.CarRandomGenerator
import kotlin.random.Random

internal class CarRandomGeneratorTest : BehaviorSpec({

    Given("CarRandomGenerator") {
        val carRandomGenerator = CarRandomGenerator

        When("Random 값이 standardValue 보다 큰 경우 ") {
            val random = mockk<Random>()
            every { random.nextInt() } returns 5

            Then("position 1 증가") {
                carRandomGenerator.canGo(standardValue = 4) shouldBe true
            }
        }
    }
})
