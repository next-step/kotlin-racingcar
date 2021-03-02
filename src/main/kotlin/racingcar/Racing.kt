package racingcar

import printer.ResultView
import printer.ResultView.printRacing

fun main() {
    val numberOfCarNames = Reception.receiveCarNames()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    val cars = Cars.createCars(numberOfCarNames)
    val racingCar = RacingCars(cars)

    ResultView.printInt()
    val carPositions = racingCar.racing(numberOfAttempts)
    printRacing(carPositions)
}
