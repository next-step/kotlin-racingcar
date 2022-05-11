package racinggame.view

import racinggame.domain.RacingGame
import racinggame.domain.car.CarFactory

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
