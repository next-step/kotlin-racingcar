package racingcar

import racingcar.model.RacingGame
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
        val racingGame = RacingGame(tryNumber = tryNumber, cars = cars)
        val result = racingGame.startGame()
        output.printWinners(result)
    }
}
