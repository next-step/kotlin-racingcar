package study.racingcar

import study.racingcar.configuration.RacingConfiguration
import study.racingcar.controller.RacingCarController
import study.racingcar.view.InputView
import study.racingcar.view.OutputView

private val racingCarController: RacingCarController = RacingConfiguration().racingCarController()

fun main() {
    val carNames: Set<String> = InputView.getCarNames()
    racingCarController.initCarNames(carNames)

    val gameCount: Int = InputView.getGameRoundCount()
    val response = racingCarController.start(gameCount)
    OutputView.printRoundResults(response)

    val cars = racingCarController.getWinners()
    OutputView.printWinners(cars)
}
