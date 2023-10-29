package race.domain

import race.ui.ResultView

class Racing(
    private val racingCarList: List<RacingCar>,
    private val round: Int,
    private val goRule: () -> Boolean = {
        (0..10).random() >= 4
    },
    private val resultView: ResultView,
) {
    init {
        require(round > 0) { "Must be at least one round!" }
    }

    fun startRace() {
        resultView.showStart()
        for (i in 1..round) {
            startRound()
            resultView.showResult(currentRacing = racingCarList, isLast = i == round)
        }
    }

    private fun startRound() {
        racingCarList.forEach { racingCar ->
            run {
                if (goRule()) {
                    racingCar.go()
                }
            }
        }
    }
}
