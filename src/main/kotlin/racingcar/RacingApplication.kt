package racingcar

import racingcar.application.RacingService
import racingcar.presentation.InputView

fun main() {
    val inputCountOfCars = InputView.inputNamesOfCars()
    val inputCountOfRacingRound = InputView.inputCountOfRacingRound()

    val racingService = RacingService()
    racingService.playNewRacingGameToEnd(inputCountOfCars, inputCountOfRacingRound)
}
