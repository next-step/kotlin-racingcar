package study.racingcar.step3

class StartRacing {
    private val inputView = InputView()
    private val ableRunNumber = 4

    fun start() {
        val carCount = inputView.inputCarCount()
        val runCount = inputView.inputRunCount()

        val racingCars = ParticipationCars(carCount, ableRunNumber).cars
        val racingRun = RacingRun(racingCars)
        val resultView = ResultView(racingCars)

        (1..runCount).forEach { _ ->
            racingRun.nextRun()
            resultView.render()
        }
    }
}
