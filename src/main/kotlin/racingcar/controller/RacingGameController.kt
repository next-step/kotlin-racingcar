package racingcar.controller

import racingcar.domain.Round
import racingcar.domain.condition.RandomCondition
import racingcar.service.RacingGameService
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(
    private val racingGameService: RacingGameService
) {
    fun run() {
        OutputView.printRequestCarCount()
        val inputCarNames = InputView.inputName()
        OutputView.printRequestAttemptCount()
        val inputAttemptCount = InputView.inputNumber()
        OutputView.printExecutionResult()

        init(inputCarNames)
        play(Round(inputAttemptCount))
    }

    private fun init(carNames: String) {
        racingGameService.initCars(carNames, RandomCondition)
    }

    private fun play(round: Round) {
        repeat(round.attemptCount) {
            racingGameService.play()
            OutputView.print()
        }
        val winners = racingGameService.getWinners()
        OutputView.printWinners(winners)
    }
}
