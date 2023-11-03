package racingcar

import racingcar.domain.Car
import racingcar.domain.CarNames
import racingcar.domain.DriveConditionImpl
import racingcar.presentation.InputManager
import racingcar.presentation.OutPutManager

class RacingCarManager(
    private val inputManager: InputManager,
    private val outPutManager: OutPutManager
) {
    fun startGame() {
        val carNames = inputManager.inputCarNames()
        val numberOfCount = inputManager.inputNumberOfCount()
        val cars = createCars(carNames)

        outPutManager.printBeginResultMessage()

        for (i in 0 until numberOfCount) {
            race(cars)
        }

        outPutManager.printWinner(getWinners(cars))
    }

    private fun race(cars: List<Car>) {
        cars.forEach { it.drive() }
        outPutManager.printCars(cars)
    }

    private fun createCars(carNames: CarNames): List<Car> {
        return List(carNames.getSize()) { Car(carNames.findNameByIndex(it), DriveConditionImpl()) }
    }

    private fun getWinners(cars: List<Car>): String {
        val maxPosition = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxPosition }
        return winners.joinToString(",") { it.name.name }
    }
}

fun main() {
    val racingCarManager = RacingCarManager(InputManager(), OutPutManager())
    racingCarManager.startGame()
}
