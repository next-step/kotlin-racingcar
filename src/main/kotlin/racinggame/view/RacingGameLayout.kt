package racinggame.view

import racinggame.domain.RacingGame
import racinggame.domain.car.CarFactory
import racinggame.domain.model.RacingGameResult

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

    fun receiveUserInput() = inputLayout.receiveUserInput()

    fun showResult(racingGameResult: RacingGameResult) {
        resultView.showResult(racingGameResult)
    }
}
