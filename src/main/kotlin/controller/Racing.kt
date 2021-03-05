package controller

import view.ResultView
import view.ResultView.printRacing
import domain.racingcar.Cars
import domain.racingcar.RacingCars
import domain.racingcar.Reception

fun main() {
    val carNames = Reception.receiveCarNames()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    val cars = Cars.createCars(carNames)
    val racingCar = RacingCars(cars)

    ResultView.printInt()
    val overallResult = racingCar.racing(numberOfAttempts)
    printRacing(overallResult)

    val winners = cars.findWinner()
    ResultView.printWinners(winners)
}
