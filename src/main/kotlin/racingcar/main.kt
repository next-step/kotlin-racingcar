package racingcar

import racingcar.fuelproviders.RandomFuelProvider
import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

fun main() {
    val game = RacingGame(
        fuelProvider = RandomFuelProvider(minFuel = 0, maxFuel = 9),
        inputView = RacingGameInputView(),
        resultView = RacingGameResultView()
    )
    game.run()
}
