package racingcar.controller

import racingcar.domain.NumberGenerator
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGameController(
    private val inputView: InputView,
    private val outputView: ResultView,
    private val numberGenerator: NumberGenerator,
) {
    private val racingGame: RacingGame

    init {
        val inputCarNames = inputView.inputCarNames()
        val inputRoundCount = inputView.inputRoundCount()
        racingGame = RacingGame(inputCarNames, inputRoundCount, numberGenerator)
    }

    fun run() {
        outputView.printResultMessage()
        while (!racingGame.isEnd()) {
            racingGame.play()
            outputView.printCurrentSituation(racingGame.extractCarNames(), racingGame.extractNowCarPositions())
        }
    }

    fun announceWinner() {
        outputView.printWinner(racingGame.getWinnerNames())
    }
}
