package racingCar

import racingCar.entity.Car
import racingCar.entity.CarImpl
import racingCar.ui.Input
import racingCar.ui.Result

class RacingCarGame {
    fun play() {
        var cars = generateCars(Input().getNumberOfCars())
        val moves = Input().getNumberOfMoves()
        repeat(moves) {
            cars = moveCars(cars)
        }
    }

    fun moveCars(cars: List<Car>): List<Car> {
        val movedCars = cars.map { car: Car -> car.move(generateRandomNumber()) }
        Result().printCarsDistanc(movedCars)
        println()
        return movedCars
    }

    fun generateCars(numberOfCars: Int): List<Car> {
        return mutableListOf<Car>().apply {
            repeat(numberOfCars) { this.add(CarImpl()) }
        }.toList()
    }

    fun generateRandomNumber(): Int {
        return (0..9).random()
    }
}
