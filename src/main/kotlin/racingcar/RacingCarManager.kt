package racingcar

import racingcar.domain.Cars
import racingcar.presentation.InputManager
import racingcar.presentation.OutPutManager

class RacingCarManager(
    private val inputManager: InputManager,
    private val outPutManager: OutPutManager
) {
    fun startGame() {
        val carNames = inputManager.inputCarNames()
        val numberOfCount = inputManager.inputNumberOfCount()
        val cars = Cars.createTo(carNames)

        outPutManager.printBeginResultMessage()

        for (i in 0 until numberOfCount) {
            cars.driveCars()
            outPutManager.printCars(cars)
        }
        outPutManager.printWinner(cars.getWinners())
    }
}

fun main() {
    val racingCarManager = RacingCarManager(InputManager(), OutPutManager())
    racingCarManager.startGame()
}
