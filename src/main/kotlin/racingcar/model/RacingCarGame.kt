package racingcar.model

import racingcar.strategy.MovingStrategy
import racingcar.view.ResultView

class RacingCarGame(
    private val strategy: MovingStrategy,
    private val numbersOfCar: Int,
    private val numbersOfTry: Int
) {
    fun start() {
        val cars = createCars(numbersOfCar)

        repeat(numbersOfTry) {
            run(cars)
            printResult(cars)
        }
    }

    private fun createCars(numbersOfCar: Int): List<Car> {
        val cars = arrayListOf<Car>()
        for (i in 1..numbersOfCar) {
            cars.add(Car(i.toString()))
        }
        return cars
    }

    private fun run(cars: List<Car>) {
        for (car in cars) {
            car.stepForward(strategy.canMove())
        }
    }

    private fun printResult(cars: List<Car>) {
        for (car in cars) {
            ResultView.printResult(car.name, car.position)
        }
        ResultView.printEmptyLine()
    }
}
