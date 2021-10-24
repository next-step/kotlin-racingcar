package racingcar

import racingcar.fuelproviders.RandomFuelProvider
import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

fun main() {
    val inputView = RacingGameInputView()
    val gameInput = inputView.receiveInput()

    val game = RacingGame(
        fuelProvider = RandomFuelProvider(minFuel = 0, maxFuel = 9),
    )
    val gameResult = game.run(gameInput)

    val resultView = RacingGameResultView()
    resultView.printResult(gameResult)
}
