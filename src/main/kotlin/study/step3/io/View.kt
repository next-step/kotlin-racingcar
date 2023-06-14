package study.step3.io

import study.step3.Scoreboard

class View(
    private val input: Input,
    private val output: Output
) {

    fun numberOfCarView(getNumberOfCar: (Int) -> Unit) {
        output.showInputNumberOfCar()
        input.requestNumberOfCar(getNumberOfCar)
    }

    fun numberOfRoundView(getNumberOfRound: (Int) -> Unit) {
        output.showInputNumberOfRound()
        input.requestNumberOfRound(getNumberOfRound)
    }

    fun resultView(scoreboard: Scoreboard) {
        output.showResult(scoreboard)
    }
}
