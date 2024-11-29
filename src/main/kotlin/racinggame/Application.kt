package racinggame

import racinggame.domain.Game
import racinggame.domain.RacingCar
import racinggame.ui.InputView
import racinggame.ui.ResultView

fun main() {
    val input = InputView()
    val resultView = ResultView()

    val game = Game.createGame(input.carNames, input.gameTurn)
    val onTurnCompletedCallback: ((Int, List<RacingCar>) -> Unit) = { currentTurn, cars ->
        if (currentTurn == 1) resultView.printInitialMessage()
        resultView.printResultOfTurn(currentTurn, cars)
    }

    game.startGame(onTurnCompletedCallback)
    resultView.printWinners(game.getResult())
}
