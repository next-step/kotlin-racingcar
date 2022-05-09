package step3.view

import step3.domain.CarFactory
import step3.domain.RacingGame

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
