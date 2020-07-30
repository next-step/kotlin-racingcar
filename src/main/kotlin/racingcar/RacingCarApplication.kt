package racingcar

import racingcar.domain.CarFactory
import racingcar.domain.RacingField
import racingcar.view.getCarNames
import racingcar.view.getTryCount
import racingcar.view.printRacingResult
import racingcar.view.printWinners

fun main() {
    val racingField = RacingField(CarFactory.create(getCarNames()))
    val racingResults = racingField.startRace(getTryCount())
    printRacingResult(racingResults)
    printWinners(racingField.getWinners())
}
