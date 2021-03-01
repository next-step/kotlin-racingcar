package racingcar

import printer.ResultView

fun main() {
    val numberOfCars = Reception.receiveNumberOfCar()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    val cars = Cars.createCars(numberOfCars)
    val racingCar = RacingCars(cars)

    ResultView.printInt()
    racingCar.racing(numberOfAttempts)
}
