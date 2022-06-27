package racingCar.ui

import racingCar.RacingCarGame
import racingCar.entity.Car

class Result {
    fun printCarsDistanc(cars: List<Car>) {
        cars.forEach { car: Car -> println(car.name + ": " + "-".repeat(car.distance)) }
    }

    fun printWinner(cars: List<Car>) {
        println(RacingCarGame().getWinner(cars).joinToString() + "가 최종 우승했습니다.")
    }
}
