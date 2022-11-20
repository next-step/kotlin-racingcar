package racingcar.controller

import racingcar.RacingGame
import racingcar.domain.Car
import racingcar.domain.Setting
import racingcar.domain.VictoryCondition
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGameController(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
) {

    private var game: RacingGame? = null
    private val victoryCondition = VictoryCondition.Longest

    fun setUpGame(setting: Setting = inputView.receiveSetting()) {
        game = RacingGame(setting.cars, setting.numberOfLab)
    }

    fun race() {
        while (game!!.isPlaying) {
            val result = game!!.playTurn()
            resultView.displayNowState(result.cars)
        }
        endGame(game!!.getLastState())
    }

    private fun endGame(cars: List<Car>) {
        val winner = victoryCondition.announceWinner(cars)
        resultView.displayWinner(winner)
        game = null
    }
}
