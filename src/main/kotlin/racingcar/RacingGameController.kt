package racingcar

import racingcar.model.RacingGame2
import racingcar.view.Input
import racingcar.view.Output

class RacingGameController(
    private val input: Input,
    private val output: Output,
    private val carFactory: CarFactory
) {

    fun start() {
        val carNames = input.getCarNames()
        val cars = carFactory.createCars(carNames)
        val tryNumber = input.getTryNumber()

        output.showStartMessage()
        val racingGame2 = RacingGame2(tryNumber = tryNumber, cars = cars)
        val result = racingGame2.startGame()
        output.printWinners(result)
    }
}
