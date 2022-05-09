package step3.view

import step3.domain.RacingGame

class RacingGameLayout(
    private val inputLayout: InputLayout,
    private val resultView: ResultView
) {
    fun execute() {
        val racingGameInput = inputLayout.receiveUserInput()
        val racingGame = RacingGame.from(racingGameInput)
        resultView.showResult(racingGame.start())
    }
}
