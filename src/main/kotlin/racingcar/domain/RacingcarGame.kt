package racingcar.domain

import racingcar.domain.car.Cars
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingcarGame(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
) {
    fun play() {
        val racingCars = Cars(inputView.inputRacingCarNames())
        val racingLap = RacingLap(inputView.inputRacingLaps())

        resultView.printRacingResult()
        while (racingLap.isNotFinished()) {
            racingCars.race()
            racingLap.waveTheFlag()
            resultView.printCurrentRace(racingCars.values)
        }
    }
}
