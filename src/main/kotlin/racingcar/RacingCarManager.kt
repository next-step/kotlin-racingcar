package racingcar

import racingcar.domain.Car
import racingcar.domain.DriveConditionImpl
import racingcar.presentation.InputManager
import racingcar.presentation.OutPutManager

class RacingCarManager(
    private val inputManager: InputManager,
    private val outPutManager: OutPutManager
) {
    fun startGame() {
        val numberOfCar = inputManager.inputNumberOfCar()
        val carNames = inputManager.inputCarNames()
        val numberOfCount = inputManager.inputNumberOfCount()
        val cars = createCars(numberOfCar)

        outPutManager.printBeginResultMessage()

        for (i in 0 until numberOfCount) {
            race(cars)
        }
    }

    private fun race(carList: List<Car>) {
        carList.forEach { it.drive() }
        outPutManager.printCarList(carList)
    }

    private fun createCars(numberOfCars: Int): List<Car> {
        return List(numberOfCars) { Car(it, DriveConditionImpl()) }
    }
}

fun main() {
    val racingCarManager = RacingCarManager(InputManager(), OutPutManager())
    racingCarManager.startGame()
}
