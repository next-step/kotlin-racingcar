package racingCar

import racingCar.entity.Car
import racingCar.entity.CarImpl
import racingCar.entity.CarImpl.Companion.MOVE_END_POINT
import racingCar.entity.CarImpl.Companion.MOVE_START_POINT
import racingCar.ui.Input
import racingCar.ui.Result

class RacingCarGame {
    fun play() {
        val cars = generateCars(Input.getCarNames())
        val moves = Input.getNumberOfMoves()
        val movedCars = getMovedCarList(cars, moves)
        Result.printWinner(movedCars)
    }

    fun getMovedCarList(cars: List<Car>, moves: Int): List<Car>{
        val movedCars = cars.toMutableList()
        repeat(moves) {
            repeat(cars.size) {
                val car = movedCars.removeFirst()
                movedCars.add(moveCar(car))
            }
            Result.printCarsDistanc(movedCars)
        }
        return movedCars
    }

    fun moveCar(car: Car): Car {
        return car.move(generateRandomNumber())
    }

    fun generateCars(carNames: List<String>): List<Car> {
        return carNames.map { name -> CarImpl(name) }
    }

    fun generateRandomNumber(): Int {
        return (MOVE_START_POINT..MOVE_END_POINT).random()
    }

    fun getMaxDistance(cars: List<Car>): Int {
        return cars.maxOf { it.distance }
    }

    fun getWinner(cars: List<Car>): List<String> {
        val maxDistance = getMaxDistance(cars)
        return cars.filter { car: Car -> car.distance == maxDistance }.map { car: Car -> car.name }
    }
}
