package car_race.logic.car

import car_race.logic.system.MovingSystem
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Cars
 */
class CarsTest : FunSpec({

    val defaultCarNameInput = "car1"
    val defaultCarNames = CarNames(defaultCarNameInput)
    val defaultCars = Cars(defaultCarNames)

    context("Cars 단위 테스트") {
        test("fun nextRound() : 차들이 movingSystem을 가지고 다음 라운드로 진행한다.") {
            val alwaysTrueSystem = object : MovingSystem {
                override fun canMove() = true
            }

            defaultCars.nextRound(alwaysTrueSystem)

            with(defaultCars.cars[0]) {
                carName.name shouldBe defaultCarNameInput
                carPosition.position shouldBe 1
            }
        }

        test("getNameAndPositionList") {
            with(defaultCars.cars[0]) {
                carName.name shouldBe defaultCarNameInput
                carPosition.position shouldBe 0
            }
        }

        test("getWinners") {
            defaultCars.getWinners()[0].carName.name shouldBe defaultCarNameInput
        }
    }
})
