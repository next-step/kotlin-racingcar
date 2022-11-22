package racingcar.controller

import racingcar.domain.CarsState
import racingcar.domain.RacingGame
import racingcar.domain.Setting
import racingcar.domain.VictoryCondition
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGameController(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
    private val victoryCondition: VictoryCondition = VictoryCondition.Longest
) {

    fun race() {
        val game = setUpGame()
        val endState = playGame(game)
        endGame(endState)
    }

    private fun setUpGame(setting: Setting = inputView.receiveSetting()): RacingGame {
        return RacingGame(setting.cars, setting.numberOfLab)
    }

    private fun playGame(game: RacingGame): CarsState {
        while (game.isPlaying) {
            val result = game.playTurn()
            resultView.displayNowState(result.cars)
        }
        return game.getLastState()
    }

    private fun endGame(state: CarsState) {
        val winner = victoryCondition.announceWinner(state.cars)
        resultView.displayWinner(winner)
    }
}
