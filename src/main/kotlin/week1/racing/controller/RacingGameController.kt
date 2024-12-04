package week1.racing.controller

import week1.racing.domain.RacingGame
import week1.racing.view.InputView
import week1.racing.view.ResultView

class RacingGameController {
    fun play() {
        val inputView = InputView()
        val carNames = inputView.readCarNames(InputView.ENTER_CAR_NAMES_MESSAGE)
        val numRounds = inputView.readIntSafelyOrZero(InputView.HOW_MANY_ROUNDS_MESSAGE)
        val game = RacingGame(carNames = carNames, numRounds = numRounds)
        game.start()
        printResults(game)
    }

    private fun printResults(game: RacingGame) {
        val resultView = ResultView()
        val finalWinner = game.getWinner()
        resultView.printRounds(game.gameRounds)
        resultView.printWinners(finalWinner)
    }
}
