package racingcar

import printer.ResultView
import printer.ResultView.printRacing

fun main() {
    val carNames = Reception.receiveCarNames()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    val cars = Cars.createCars(carNames)
    val racingCar = RacingCars(cars)

    ResultView.printInt()
    val carPositions = racingCar.racing(numberOfAttempts)
    printRacing(carNames, carPositions)

    val winners = cars.findWinner()
    ResultView.printWinners(winners)
}
