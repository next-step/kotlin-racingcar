package racingcar.domain

import racingcar.view.OutputView

const val MOVE_FORWARD = 4

class Cars {
    private val cars = mutableListOf<Car>()

    fun startRace(gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy) {
        val outputView = OutputView()
        var splitNameOfCarsSize = splitInputValue(gameInputValue.inputNameOfCars).size
        make(splitNameOfCarsSize, movingConditionStrategy)
        iterateNumberOfGames(splitNameOfCarsSize, outputView)
    }

    private fun make(numberOfCars: Int, movingConditionStrategy: MovingConditionStrategy) {

        for (i in 0 until numberOfCars) {
            cars.add(Car(movingConditionStrategy))
        }
    }

    private fun splitInputValue(inputValue: String): List<String> {
        return inputValue.split(INPUT_VALUE_DELIMITER)
    }

    private fun iterateNumberOfGames(nameOfCarsSize: Int, outputView: OutputView) {
        for (numberOfGames in 0 until nameOfCarsSize) {
            iterateNumberOfCars(nameOfCarsSize, outputView)
        }
    }

    private fun iterateNumberOfCars(nameOfCarsSize: Int, outputView: OutputView) {
        for (numberOfCars in 0 until nameOfCarsSize) {
            moveCar(numberOfCars)
            showCarPosition(numberOfCars, nameOfCarsSize, outputView)
        }
    }

    private fun moveCar(numberOfCars: Int) {
        cars[numberOfCars].move()
    }

    private fun showCarPosition(numberOfCars: Int, nameOfCarsSize: Int, outputView: OutputView) {
        cars[numberOfCars].showPosition(isLastCarCycle(numberOfCars, nameOfCarsSize), outputView)
    }

    private fun isLastCarCycle(numberOfCar: Int, nameOfCarsSize: Int): Boolean {
        return numberOfCar == nameOfCarsSize - 1
    }
}
