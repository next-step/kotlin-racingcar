package racingcar.controller

import racingcar.domain.NumberGenerator
import racingcar.domain.RacingGame
import racingcar.domain.to.GameHistoryResponse
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator,
) {
    private val racingGame: RacingGame
    private val inputCarNames = inputView.inputCarNames()
    private val inputRoundCount = inputView.inputRoundCount()

    init {
        racingGame = RacingGame(inputCarNames, inputRoundCount, numberGenerator)
    }

    fun run() {
        while (!racingGame.isEnd()) {
            racingGame.play()
        }
        outputView.printResult(inputRoundCount, GameHistoryResponse(racingGame.extractRaceHistory()))
    }

    fun announceWinner() {
        outputView.printWinner(racingGame.getWinnerNames())
    }
}
