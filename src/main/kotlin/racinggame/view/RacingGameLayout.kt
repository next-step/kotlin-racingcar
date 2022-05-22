package racinggame.view

import racinggame.domain.model.RacingGameResult

class RacingGameLayout(
    private val inputLayout: InputLayout,
    private val resultView: ResultView
) {
    fun receiveUserInput() = inputLayout.receiveUserInput()

    fun showResult(racingGameResult: RacingGameResult) {
        resultView.showResult(racingGameResult)
    }
}
