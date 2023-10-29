package racing

import racing.model.RacingCar
import racing.view.InputView
import racing.view.OutputView

fun main() {
    val racingCar = RacingCar()
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printResults(
        racingCar.race(
            inputView.participate(),
            inputView.roundCount()
        )
    )
}
