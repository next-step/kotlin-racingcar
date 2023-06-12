package racingcar

import racingcar.domain.car.CarFactory
import racingcar.domain.game.RacingGame
import racingcar.ui.input.InputView
import racingcar.ui.output.OutputView

class RacingCarController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val carNames = inputView.getCarNames()
        val numberOfRounds = inputView.getNumberOfRounds()

        val cars = CarFactory.getCars(carNames)
        val racingGame = RacingGame(cars)

        outputView.announceResult()
        repeat(numberOfRounds) {
            outputView.announceRoundStart(it)
            racingGame.startRound()
            outputView.printCars(cars)
        }
        val winners = racingGame.getWinnerCars()
        outputView.printWinner(winners)
    }
}

fun main() {
    val racingCarController = RacingCarController()
    racingCarController.start()
}
