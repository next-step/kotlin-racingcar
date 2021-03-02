package racingcar

import printer.ResultView
import printer.ResultView.printRacing

fun main() {
    val numberOfCars = Reception.receiveNumberOfCar()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    val cars = Cars.createCars(numberOfCars)
    val racingCar = RacingCars(cars)

    ResultView.printInt()
    val carPositions = racingCar.racing(numberOfAttempts)
    printRacing(numberOfAttempts, carPositions)
}
