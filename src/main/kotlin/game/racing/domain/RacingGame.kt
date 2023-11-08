package game.racing.domain

import game.racing.util.getRandomValue
import game.racing.view.ResultView

class RacingGame(private val racingManager: RacingManager, private val tryNumber: Int) {
    fun start() {
        ResultView.printResultIntroduction()
        repeat(tryNumber) {
            racingManager.moveCars { getRandomValue() }
            ResultView.printResult(racingManager.cars)
        }
        ResultView.printWinner(racingManager.determineWinner())
    }
}
