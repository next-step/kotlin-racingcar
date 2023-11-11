package game.racing.controller

import game.racing.domain.Car
import game.racing.domain.RacingManager
import game.racing.view.ResultView

class RacingGameController(private val racingManager: RacingManager) {
    fun tryMovesRepeatedly(tryNumber: Int): List<List<Car>> {
        val resultList = mutableListOf<List<Car>>()
        repeat(tryNumber) {
            resultList.add(racingManager.moveCars { Car.generateRandomMoveDecision() }.map { it.copy() })
        }
        return resultList
    }

    fun initializeGame() {
        ResultView.printResultIntroduction()
        ResultView.printResult(racingManager.cars)
    }

    fun showGameResult(resultList: List<List<Car>>) {
        resultList.forEach(ResultView::printResult)
        ResultView.printWinner(racingManager.determineWinner())
    }
}
