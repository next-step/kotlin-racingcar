package racingcar.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.component.CarMovementManager
import racingcar.component.RacingcarGameContext
import racingcar.model.Car

class RacingcarGameContextTest : FunSpec({
    context("test round") {
        test("distance changed after some rounds") {
            val car = Car()
            val carMovementManager = CarMovementManager { true }
            val racingcarGameContext = RacingcarGameContext(
                listOf(car),
                carMovementManager
            )

            for (i: Int in 0..2) {
                racingcarGameContext.doRound()
            }

            car.currentDistance() shouldBe 3
        }

        test("check multiple winners") {
            val cars = listOf(
                Car(1), Car(1)
            )
            val carMovementManager = CarMovementManager { true }
            val racingcarGameContext = RacingcarGameContext(
                cars,
                carMovementManager
            )

            val result = racingcarGameContext.getWinners()

            result.size shouldBe 2
        }
    }
})
