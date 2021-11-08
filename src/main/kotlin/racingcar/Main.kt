package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RandomNumberStrategy

class Main

fun main(args: Array<String>) {
    val input = Input()
    val result = Result()
    val cars = Cars()

    val carCount: Int = input.carCount()
    val trialCount: Int = input.trialCount()

    for (i in 1..carCount) {
        cars.addCar(Car())
    }

    for (i in 1..trialCount) {
        cars.race(RandomNumberStrategy())
        result.displayCarsResult(cars)
    }
}