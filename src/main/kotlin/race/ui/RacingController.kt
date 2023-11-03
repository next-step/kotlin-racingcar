package race.ui

import race.domain.Racing
import race.domain.RacingCar

class RacingController(
    inputView: InputView,
    resultView: ResultView
) {
    init {
        val inputState = inputView.getInputState()
        val racingResult = Racing(
            racingCarList = inputState.carNames.map { RacingCar(name = it) },
            round = inputState.round,
        ).startRace()

        resultView.showResult(racingResult)
    }
}
