package racingcar.model

import racingcar.strategy.MovingStrategy

class RacingCarGame(
    private val strategy: MovingStrategy,
    private val numbersOfCar: Int,
    private val numbersOfTry: Int
) {
    fun start(): List<Car> {
        val cars = createCars(numbersOfCar)

        repeat(numbersOfTry) {
            run(cars)
        }
        return cars
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
}
