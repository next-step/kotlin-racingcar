package racingCar

import racingCar.entity.Car
import racingCar.entity.CarImpl
import racingCar.ui.Input
import racingCar.ui.Result

class RacingCarGame {
    fun play() {
        val cars = generateCars(Input().getCarNames())
        val moves = Input().getNumberOfMoves()
        repeat(moves) {
            getMovedCarList(cars)
        }
        Result().printWinner(cars)
    }

    fun getMovedCarList(cars: List<Car>): List<Car>{
        val movedCars = cars.toMutableList()
        repeat(cars.size) {
            val car = movedCars.removeFirst()
            movedCars.add(moveCar(car))
        }
        Result().printCarsDistanc(movedCars)
        return movedCars
    }

    fun moveCar(car: Car): Car {
        return car.move(generateRandomNumber())
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
