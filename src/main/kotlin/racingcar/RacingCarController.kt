package racingcar

import racingcar.domain.RacingCarGame
import racingcar.domain.SeedMakerImpl
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController(private val inputView: InputView, private val resultView: ResultView) {

    private val seedMaker = SeedMakerImpl()

    fun start() {
        val carNames = inputView.getCarNamesInput(InputView.CAR_NAMES_INPUT_DESC)
        val trialCount = inputView.getNaturalNumberInput(InputView.TRIAL_NUMBER_INPUT_DESC)

        val racingCarGame = RacingCarGame(trialCount, seedMaker, carNames)
        racingCarGame.play()

        val gameResult = racingCarGame.gameResults
        resultView.printGameHistory(gameResult)
        resultView.printWinnerResult(racingCarGame.getWinnerResult())
    }
}
