package racingcar.domain

import racingcar.view.OutputView

const val MOVE_FORWARD = 4
const val MOVE_MARKER = "- "

class Cars {
    private val cars = mutableListOf<Car>()

    fun startRace(gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy) {
        val outputView = OutputView()
        makeCars(gameInputValue.inputNumberOfCar)
        iterateNumberOfGames(gameInputValue, movingConditionStrategy, outputView)
    }

    private fun makeCars(numberOfCar: Int) {
        for (i in 0 until numberOfCar) {
            cars.add(Car())
        }
    }

    private fun iterateNumberOfGames(gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy, outputView: OutputView) {
        for (numberOfTry in 0 until gameInputValue.inputNumberOfTry) {
            iterateNumberOfCars(gameInputValue, movingConditionStrategy, outputView)
        }
    }

    private fun iterateNumberOfCars(gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy, outputView: OutputView) {
        for (numberOfCar in 0 until gameInputValue.inputNumberOfCar) {
            makeRaceState(numberOfCar, gameInputValue, movingConditionStrategy, outputView)
        }
    }

    private fun makeRaceState(numberOfCar: Int, gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy, outputView: OutputView) {
        val isLastCarCycle = numberOfCar == gameInputValue.inputNumberOfCar - 1
        if (movingConditionStrategy.move() >= MOVE_FORWARD) {
            setCarPosition(numberOfCar, MOVE_MARKER)
        }
        outputView.showRaceState(getCarPosition(numberOfCar), isLastCarCycle)
    }

    private fun setCarPosition(index: Int, value: String) {
        cars[index].position += value
    }

    private fun getCarPosition(index: Int): String {
        return cars[index].position
    }
}
