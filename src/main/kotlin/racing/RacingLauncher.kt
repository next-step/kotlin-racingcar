package racing

import racing.domain.RandomMovable
import racing.view.InputView
import racing.view.OutputView

internal class RacingLauncher {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val racingFactory = RacingFactory()

    fun play() {
        val numberOfCar = inputView.queryNumberOfCar()
        val numberOfRound = inputView.queryNumberOfRound()
        val movable = RandomMovable()
        val racing = racingFactory.createRacing(numberOfCar = numberOfCar, movable = movable)

        outputView.renderStartMessage()

        repeat(numberOfRound) {
            racing.tryMove()
            outputView.renderPositions(racing.positions)
        }
    }
}

fun main() {
    RacingLauncher().play()
}
