package game.racing.controller

import game.racing.domain.Car
import game.racing.domain.RacingGame
import game.racing.view.ResultView

object RacingGameController {
    fun progressGame(racingGame: RacingGame, tryNumber: Int): List<List<Car>> {
        return racingGame.tryMovesRepeatedly(tryNumber)
    }

    fun showGameResult(resultList: List<List<Car>>, winners: List<Car>) {
        resultList.forEach(ResultView::printResult)
        ResultView.printWinner(winners)
    }
}
