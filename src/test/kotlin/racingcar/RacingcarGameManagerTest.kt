package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.model.Car

class RacingcarGameManagerTest : FunSpec({
    context("test round") {
        test("distance changed after some rounds") {
            val car = Car()
            val carMovementManager = CarMovementManager { true }
            val racingcarGameManager = RacingcarGameManager(
                listOf(car),
                carMovementManager
            )

            for (i: Int in 0..2) {
                racingcarGameManager.doRound()
            }

            car.currentDistance() shouldBe 3
        }

        test("check multiple winners") {
            val cars = listOf(
                Car(1), Car(1)
            )
            val carMovementManager = CarMovementManager { true }
            val racingcarGameManager = RacingcarGameManager(
                cars,
                carMovementManager
            )

            val result = racingcarGameManager.getWinners()

            result.size shouldBe 2
        }
    }
})
