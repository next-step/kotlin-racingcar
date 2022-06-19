package racingCar.ui

import racingCar.entity.Car

class Result {
    fun printCarsDistanc(cars: List<Car>) {
        cars.forEach { car: Car -> println("-".repeat(car.distance)) }
    }
}
