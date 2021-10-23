package racingcar

import racingcar.fuelproviders.RandomFuelProvider
import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

fun main() {
    val inputView = RacingGameInputView()
    val resultView = RacingGameResultView()
    val game = RacingGame(
        fuelProvider = RandomFuelProvider(minFuel = 0, maxFuel = 9),
    )

    val gameInput = inputView.receiveInput()
    val gameResult = game.run(gameInput)
    resultView.printResult(gameResult)

}
