package racingcar.domain

import racingcar.view.OutputView

class Cars {
    private val cars = mutableListOf<Car>()

    fun startRace(gameInputValue: GameInputValue, movingConditionStrategy: MovingConditionStrategy) {
        val outputView = OutputView()
        make(gameInputValue.inputNameOfCars, movingConditionStrategy)
        iterateNumberOfGames(gameInputValue, outputView)
    }

    private fun make(numberOfCars: List<String>, movingConditionStrategy: MovingConditionStrategy) {

        for (i in numberOfCars.indices) {
            cars.add(Car(movingConditionStrategy, numberOfCars[i]))
        }
    }

    private fun iterateNumberOfGames(gameInputValue: GameInputValue, outputView: OutputView) {
        for (numberOfGames in 0 until gameInputValue.inputNumberOfGames) {
            iterateNumberOfCars(gameInputValue, outputView)
        }
    }

    private fun iterateNumberOfCars(gameInputValue: GameInputValue, outputView: OutputView) {
        for (numberOfCars in 0 until gameInputValue.inputNameOfCars.size) {
            moveCar(numberOfCars)
            showCarPosition(numberOfCars, gameInputValue.inputNameOfCars.size, outputView)
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
