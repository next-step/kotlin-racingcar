package study.step3.view

import study.step3.domain.Scoreboard

class View(
    private val input: Input,
    private val output: Output
) {

    fun numberOfCarView(getCarNames: (List<String>) -> Unit) {
        output.showInputCarNames()
        input.requestCarNames(getCarNames)
    }

    fun numberOfRoundView(getNumberOfRound: (Int) -> Unit) {
        output.showInputNumberOfRound()
        input.requestNumberOfRound(getNumberOfRound)
    }

    fun resultView(scoreboard: Scoreboard) {
        output.showProcess(title = "실행 결과", scoreboard = scoreboard)
        output.showWinners(scoreboard = scoreboard)
    }
}
