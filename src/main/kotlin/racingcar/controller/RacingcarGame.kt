package racingcar.controller

import racingcar.domain.GasStation
import racingcar.domain.RacingLap
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.CarName
import racingcar.domain.car.CarNames
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingcarGame(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
) {
    fun play() {
        val carNames = CarNames(inputView.inputRacingCarNames().split(REGEX).map { CarName(it) })
        val racingCars = Cars(carNames.values.map { Car(it) })
        val racingLap = RacingLap(inputView.inputRacingLaps())
        val gasStation = GasStation()

        resultView.printRacingResult()
        while (racingLap.isNotFinished()) {
            racingCars.race(gasStation = gasStation)
            racingLap.waveTheFlag()
            resultView.printCurrentRace(racingCars.values)
        }

        resultView.printWinners(racingCars.getWinnerNames())
    }

    companion object {
        private const val REGEX = ","
    }
}
