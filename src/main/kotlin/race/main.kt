package race

import race.domain.Racing
import race.domain.RacingCar
import race.ui.InputView
import race.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    Racing(
        racingCarList = inputView.state.carNames.map { RacingCar(name = it) },
        round = inputView.state.round,
        resultView = resultView,
    ).startRace()
}
