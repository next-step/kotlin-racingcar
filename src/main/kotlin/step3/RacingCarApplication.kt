package step3

import step3.domain.CarFactory
import step3.domain.RacingField
import step3.view.getCarNames
import step3.view.getTryCount
import step3.view.printRacingResult
import step3.view.printWinners

fun main() {
    val racingField = RacingField(CarFactory.create(getCarNames()))
    val racingResults = racingField.startRace(getTryCount())
    printRacingResult(racingResults)
    printWinners(racingField.getWinners())
}
