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
        val game = gameBuilder.createGame(gameArgument)
        this.currentGame = game
        game.runGame(resultView::printRacingGame)
    }
}
