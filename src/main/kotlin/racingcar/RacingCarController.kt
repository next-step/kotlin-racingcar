package racingcar

import racingcar.car.CarFactory
import racingcar.game.RacingGame
import racingcar.input.InputView
import racingcar.output.OutputView

class RacingCarController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val numberOfCars = inputView.getNumberOfCars()
        val numberOfRounds = inputView.getNumberOfRounds()

        val cars = CarFactory.getCars(numberOfCars)
        val racingGame = RacingGame(cars)

        outputView.announceResult()
        repeat(numberOfRounds) {
            outputView.announceRoundStart(it)
            racingGame.startRound()
            outputView.printCars(cars)
        }
    }
}

fun main() {
    val racingCarController = RacingCarController()
    racingCarController.start()
}
