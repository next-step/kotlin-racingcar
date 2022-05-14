package racingcar.domain

import racingcar.view.InputView
import racingcar.view.ResultView

class RacingcarGame(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
) {
    fun play() {
        val racingCars = Cars(inputView.inputCountOfCars())
        val racingLap = RacingLap(inputView.inputRacingLaps())

        resultView.printRacingResult()
        while (racingLap.isNotFinished()) {
            racingCars.race()
            racingLap.waveTheFlag()
            resultView.printCurrentRace(racingCars.values)
        }
    }
}
