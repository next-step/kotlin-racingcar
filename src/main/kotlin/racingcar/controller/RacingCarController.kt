package racingcar.controller

import racingcar.service.RacingCarService
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController(private val racingCarService: RacingCarService) {
    fun start() {
        ResultView.showRacingStart()
        InputView.readRacingCarNames()
        val carNamesInput = readln()
        val carNames = racingCarService.readRacingCarNames(carNamesInput)

        InputView.readTryCount()
        val tryCountInput = readln().toInt()
        val tryCount = racingCarService.readTryCount(tryCountInput)

        ResultView.showRacingStart()
        val raceCars = racingCarService.runRace(carNames, tryCount)

        val raceResults = racingCarService.mapToDtos(raceCars)
        ResultView.showRacingResult(raceResults)

        val winners = racingCarService.determineWinners(raceCars)
        ResultView.showWinner(winners)
    }
}
