package racingCar

import racingCar.entity.Car
import racingCar.entity.CarImpl
import racingCar.ui.Input
import racingCar.ui.Result

class RacingCarGame {
    fun play() {
        var cars = generateCars(Input().getCarNames())
        val moves = Input().getNumberOfMoves()
        repeat(moves) {
            cars = moveCars(cars)
        }
        Result().printWinner(cars)
    }

    fun moveCars(cars: List<Car>): List<Car> {
        val movedCars = cars.map { car: Car -> car.move(generateRandomNumber()) }
        Result().printCarsDistanc(movedCars)
        println()
        return movedCars
    }

    fun generateCars(carNames: List<String>): List<Car> {
        return carNames.map { name -> CarImpl(name) }
    }

    fun generateRandomNumber(): Int {
        return (0..9).random()
    }

    fun getMaxDistance(cars: List<Car>): Int {
        return cars.maxWithOrNull(Comparator.comparingInt { it.distance })!!.distance
    }

    fun getWinner(cars: List<Car>): List<String> {
        val maxDistance = getMaxDistance(cars)
        return cars.filter { car: Car -> car.distance == maxDistance }.map { car: Car -> car.name }
    }
}
