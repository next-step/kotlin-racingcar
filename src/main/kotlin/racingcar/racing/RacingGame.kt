package racingcar.racing

import racingcar.domain.Cars
import racingcar.domain.Input
import racingcar.io.ResultView
import racingcar.util.NumberGenerator
import racingcar.util.RandomNumberGenerator

class RacingGame(
    private val input: Input,
    numberGenerator: NumberGenerator = RandomNumberGenerator()
) {
    val cars: Cars = Cars(numberGenerator, input.carCount)

    fun start() {
        ResultView.printResultMessage()
        repeat(input.rounds) {
            runRound()
        }
    }

    fun runRound() {
        cars.moveAll()
        ResultView.printRound(cars)
    }
}
