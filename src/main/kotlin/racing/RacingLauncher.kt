package racing

import racing.domain.RacingFactory
import racing.view.InputView
import racing.view.OutputView

internal class RacingLauncher {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val racingFactory = RacingFactory()

    fun play() {
        val carNames = inputView.queryCarNames()
        val numberOfRound = inputView.queryNumberOfRound()
        val racing = racingFactory.createRandomRacing(carNames = carNames)

        outputView.renderResult(racing.race(numberOfRound), racing.winners)
    }
}

fun main() {
    RacingLauncher().play()
}
