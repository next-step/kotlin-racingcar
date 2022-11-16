package step3.controller

import step3.domain.game.RacingGame
import step3.infra.io.RacingGameInputReader
import step3.view.input.InputView
import step3.view.input.impl.InputViewWithCarCountImpl
import step3.view.result.DefaultResultView
import step3.view.result.ResultView
import step3.view.result.history.impl.RacingGameHistoryViewImpl

class RacingGameController(
    private val inputView: InputView = InputViewWithCarCountImpl(),
    private val resultView: ResultView = DefaultResultView(
        racingGameHistoryView = RacingGameHistoryViewImpl()
    ),
    private val inputReader: RacingGameInputReader = RacingGameInputReader()
) {
    fun run() {
        inputView.printInputViewForTotalCarCount()

        val totalCarCount = inputReader.readInputForTotalCarCount()

        inputView.printInputViewForTotalTryCount()

        val totalTryCount = inputReader.readInputForTotalTryCount()

        val racingGame = RacingGame(totalCarCount = totalCarCount, totalTryCount = totalTryCount)

        racingGame.nextStepAll()

        println()

        resultView.printRacingGameResult(racingGame)
    }
}
