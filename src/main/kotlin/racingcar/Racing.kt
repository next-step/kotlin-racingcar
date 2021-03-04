package racingcar

import printer.ResultView
import printer.ResultView.printRacing

fun main() {
    val carNames = Reception.receiveCarNames()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    val cars = Cars.createCars(carNames)
    val racingCar = RacingCars(cars)

    ResultView.printInt()
    val rounds = racingCar.racing(numberOfAttempts)
    printRacing(rounds)

    val winners = cars.findWinner()
    ResultView.printWinners(winners)
}
