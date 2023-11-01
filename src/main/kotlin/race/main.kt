package race

import race.domain.Racing
import race.domain.RacingCar
import race.ui.InputView
import race.ui.ResultView

fun main() {
    val inputState = InputView().getInputState()
    val resultView = ResultView()

    Racing(
        racingCarList = inputState.carNames.map { RacingCar(name = it) },
        round = inputState.round,
        resultView = resultView,
    ).startRace()
}
