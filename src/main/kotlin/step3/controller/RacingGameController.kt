package step3.controller

import step3.domain.game.RacingGame
import step3.infra.io.RacingGameInputReader
import step3.view.input.InputView
import step3.view.input.impl.InputViewWithCarCountImpl
import step3.view.result.ResultView
import step3.view.result.history.impl.RacingGameHistoryViewImpl
import step3.view.result.winner.impl.RacingGameWinnerViewImpl

class RacingGameController(
    private val inputView: InputView = InputViewWithCarCountImpl(),
    private val resultView: ResultView = ResultView(
        racingGameHistoryView = RacingGameHistoryViewImpl(),
        racingGameWinnerView = RacingGameWinnerViewImpl()
    ),
    private val inputReader: RacingGameInputReader = RacingGameInputReader()
) {
    fun run() {
        inputView.printInputViewForTotalCarCount()

        val carNameList = inputReader.readInputForCarNameList()

        inputView.printInputViewForTotalTryCount()

        val totalTryCount = inputReader.readInputForTotalTryCount()

        val racingGame = RacingGame(carNameList = carNameList, totalTryCount = totalTryCount)

        racingGame.nextStepAll()

        println()

        resultView.printRacingGameResult(racingGame)
    }
}
