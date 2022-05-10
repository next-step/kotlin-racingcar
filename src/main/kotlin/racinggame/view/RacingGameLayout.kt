package racinggame.view

import racinggame.domain.CarFactory
import racinggame.domain.RacingGame

class RacingGameLayout(
    private val inputLayout: InputLayout,
    private val resultView: ResultView
) {
    fun execute(carFactory: CarFactory) {
        val racingGameInput = inputLayout.receiveUserInput()
        val racingGame = RacingGame.of(
            racingGameInput,
            carFactory
        )
        resultView.showResult(racingGame.start())
    }
}
