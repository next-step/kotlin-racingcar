package racing.application

import racing.domain.RacingGame
import racing.view.InputView
import racing.view.ResultView

class RacingGameService {

    fun main() {
        val racingCarNames = InputView.requireRacingCarNames()
        val numberOfGames = InputView.requireNumberOfGames()

        val racingGame = RacingGame()
        val winCars = racingGame.start(racingCarNames, numberOfGames)
        ResultView.printRacingGameGuideText()
        ResultView.printRacingGameWinner(winCars)
    }
}
