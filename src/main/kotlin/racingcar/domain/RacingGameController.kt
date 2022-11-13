package racingcar.domain

import racingcar.view.OutputView

const val MOVE_FORWARD = 4
const val MOVE_MARKER = "- "

class RacingGameController {
    private val outputView = OutputView()
    private lateinit var cars: MutableList<Car>
    lateinit var gameInputValue: GameInputValue

    fun start(gameInputValue: GameInputValue) {
        this.gameInputValue = gameInputValue
        cars = CarMaker().make(gameInputValue.inputNumberOfCar)
        iterateNumberOfTry()
    }

    private fun iterateNumberOfTry() {
        for (numberOfTry in 0 until gameInputValue.inputNumberOfTry) {
            iterateNumberOfCar()
        }
    }

    private fun iterateNumberOfCar() {
        for (numberOfCar in 0 until gameInputValue.inputNumberOfCar) {
            makeResult(numberOfCar)
        }
    }

    private fun makeResult(numberOfCar: Int) {
        val isLastCarCycle = numberOfCar == gameInputValue.inputNumberOfCar - 1
        if (MovingConditionMaker().make() >= MOVE_FORWARD) {
            cars[numberOfCar].position += MOVE_MARKER
        }
        outputView.showResult(cars[numberOfCar].position, isLastCarCycle)
    }
}
