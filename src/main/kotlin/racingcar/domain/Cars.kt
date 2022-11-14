package racingcar.domain

import racingcar.view.OutputView

const val MOVE_FORWARD = 4

class Cars {
    private val cars = mutableListOf<Car>()

    fun startRace(gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy) {
        val outputView = OutputView()
        make(gameInputValue.inputNumberOfCars, movingConditionStrategy)
        iterateNumberOfGames(gameInputValue, outputView)
    }

    private fun make(numberOfCar: Int, movingConditionStrategy: MovingConditionStrategy) {
        for (i in 0 until numberOfCar) {
            cars.add(Car(movingConditionStrategy))
        }
    }

    private fun iterateNumberOfGames(gameInputValue: GameInputValue, outputView: OutputView) {
        for (numberOfGames in 0 until gameInputValue.inputNumberOfGames) {
            iterateNumberOfCars(gameInputValue, outputView)
        }
    }

    private fun iterateNumberOfCars(gameInputValue: GameInputValue, outputView: OutputView) {
        for (numberOfCars in 0 until gameInputValue.inputNumberOfCars) {
            moveCar(numberOfCars)
            showCarPosition(numberOfCars, gameInputValue, outputView)
        }
    }

    private fun moveCar(numberOfCars: Int) {
        cars[numberOfCars].move()
    }

    private fun showCarPosition(numberOfCars: Int, gameInputValue: GameInputValue, outputView: OutputView) {
        cars[numberOfCars].showPosition(isLastCarCycle(numberOfCars, gameInputValue), outputView)
    }

    private fun isLastCarCycle(numberOfCar: Int, gameInputValue: GameInputValue): Boolean {
        return numberOfCar == gameInputValue.inputNumberOfCars - 1
    }
}
