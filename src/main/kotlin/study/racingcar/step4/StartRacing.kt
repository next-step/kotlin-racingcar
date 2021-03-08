package study.racingcar.step4

import study.racingcar.step4.domain.ParticipationCars
import study.racingcar.step4.view.InputView
import study.racingcar.step4.view.ResultView

class StartRacing {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val ableRunNumber = 4
    private val randomMaxNumber = 9

    fun start() {
        val carNameList = inputView.inputCarNameList()
        val runnable = RandomRunnable(ableRunNumber, randomMaxNumber)

        val racingRun = RacingRunner(ParticipationCars(carNameList).cars)

        (1..inputView.inputRunCount()).forEach {
            racingRun.nextRun(runnable)
            resultView.render(racingRun.racingRecords())
        }
        resultView.renderResult(racingRun.getWinnerCarNamesAsString())
    }
}
