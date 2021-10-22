package racingcar

import racingcar.fuelproviders.RandomFuelProvider
import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

fun main() {
    val gameInput = RacingGameInputView().receiveInput()
    val randomFuelProvider = RandomFuelProvider(minFuel = 0, maxFuel = 9)
    val game = RacingGame(fuelProvider = randomFuelProvider)
    val gameResult = game.run(gameInput)
    RacingGameResultView().printResult(gameResult)
}
