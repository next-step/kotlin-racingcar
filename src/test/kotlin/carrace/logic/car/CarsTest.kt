package carrace.logic.car

import carrace.logic.system.MovingSystem
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Cars
 */
internal class CarsTest : FunSpec({

    val defaultCarNameInput = "car1"
    val defaultCarNames = CarNames(defaultCarNameInput)
    val defaultCar = Car(defaultCarNames.names[0])
    val defaultCars = Cars(listOf(defaultCar))
    val defaultWinner = Winners(listOf(defaultCar))

    context("Cars 단위 테스트") {
        test("fun nextRound() : 차들이 movingSystem을 가지고 다음 라운드로 진행한다.") {
            val alwaysTrueSystem = object : MovingSystem {
                override fun canMove() = true
            }

            val nextRoundCarInfos = defaultCars.nextRound(alwaysTrueSystem)

            with(nextRoundCarInfos.carInfos[0]) {
                carName.name shouldBe defaultCarNameInput
                carPosition.position shouldBe 1
            }
        }

        test("fun getWinners(): 우승자 리스트를 반환한다.") {
            defaultCars.getWinners() shouldBe defaultWinner
        }
    }
})
