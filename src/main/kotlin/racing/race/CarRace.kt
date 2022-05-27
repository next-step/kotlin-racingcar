package racing.race

import racing.common.CarRaceProperty
import racing.view.ResultView

class CarRace(
    private val carRaceProperty: CarRaceProperty,
    private val resultView: ResultView,
) {
    fun start() {
        for (round in CarRaceProperty.ROUND_START..carRaceProperty.roundSize) {
            carRaceProperty.cars.map { it.move() }
            resultView.printResultByRound(round)
        }

        val winnerJudge = WinnerJudge(carRaceProperty)
        resultView.printWinner(winnerJudge.getWinnerCarNames())
    }
}
