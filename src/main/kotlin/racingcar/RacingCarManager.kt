package racingcar

import racingcar.domain.Car
import racingcar.domain.DriveConditionImpl
import racingcar.presentation.InputManager
import racingcar.presentation.OutPutManager

class RacingCarManager(
    val inputManager: InputManager,
    val outPutManager: OutPutManager
) {
    fun startGame() {
        val numberOfCar = inputManager.inputNumberOfCar()
        val numberOfCount = inputManager.inputNumberOfCount()
        val carList: MutableList<Car> = mutableListOf()

        setCarList(numberOfCar, carList)

        outPutManager.printBeginResultMessage()

        for(i in 0 until numberOfCount) {
            race(carList)
        }
    }

    private fun race(carList: MutableList<Car>) {
        carList.forEach { it.drive() }
        outPutManager.printCarList(carList)
    }

    private fun setCarList(
        numberOfCar: Int,
        carList: MutableList<Car>,
    ) {
        repeat(numberOfCar) {
            carList.add(Car(it, DriveConditionImpl()))
        }
    }
}

fun main() {
    val racingCarManager = RacingCarManager(InputManager(), OutPutManager())
    racingCarManager.startGame()
}