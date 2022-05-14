package racingcar

import racingcar.domain.RacingCarGame
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController(private val inputView: InputView, private val resultView: ResultView) {

    fun start() {
        val carNames = inputView.getCarNamesInput()
        val trialCount = inputView.getNaturalNumberInput()

        val racingCarGame = RacingCarGame(trialCount = trialCount, carNameList = carNames)
        racingCarGame.play()

        val gameResult = racingCarGame.gameResults
        resultView.printGameHistory(gameResult)
        resultView.printWinnerResult(racingCarGame.getWinnerResult())
    }
}
