package step3

import step3.view.getCarNames
import step3.view.getTryCount
import step3.view.printRacingResult

fun main() {
    val racingField = RacingField(CarFactory.create(getCarNames()))
    val racingResult = racingField.startRace(getTryCount())
    printRacingResult(racingResult)
}
