package study.racingcar.step4

class StartRacing {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val ableRunNumber = 4

    fun start() {
        val carNameList = inputView.inputCarNameList()
        val runCount = inputView.inputRunCount()

        val racingRun = RacingRun(ParticipationCars(carNameList, ableRunNumber).cars)

        (1..runCount).forEach {
            racingRun.nextRun()
            resultView.render(racingRun.racingRecords())
        }
        resultView.renderResult(racingRun.getWinnerCarNamesAsString())
    }
}
