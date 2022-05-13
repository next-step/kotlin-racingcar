package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.input.InputView
import racingcar.view.output.DefaultResultView
import racingcar.view.output.ResultView

class RacingGameController<T>(
    private val inputView: InputView<T>,
    private val gameBuilder: GameBuilder<T>,
    private val resultView: ResultView = DefaultResultView()
) {

    var currentGame: RacingGame? = null
        private set

    fun executeGame() {
        val gameArgument = inputView.showInputView()
        val game = createNewGame(gameArgument)
        val racingRecord = game.runGame()
        resultView.showResultView(racingRecord = racingRecord)
    }

    private fun createNewGame(gameArgument: T): RacingGame {
        val game = gameBuilder.createGame(gameArgument)
        this.currentGame = game
        return game
    }
}
