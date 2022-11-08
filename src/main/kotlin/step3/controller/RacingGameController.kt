package step3.controller

import step3.domain.RacingGame
import step3.infra.RacingGameInputReader
import step3.infra.impl.DefaultRacingGameInputReader
import step3.view.input.DefaultInputView
import step3.view.input.InputView
import step3.view.result.DefaultResultView
import step3.view.result.ResultView

class RacingGameController(
    private val inputView: InputView = DefaultInputView(),
    private val resultView: ResultView = DefaultResultView(),
    private val inputReader: RacingGameInputReader = DefaultRacingGameInputReader()
) : RacingGameInputReader by inputReader {
    fun run() {
        inputView.printInputViewForTotalCarCount()
        val racingCarNameList = readInput().trim().split(",")

        inputView.printInputViewForTotalTryCount()
        val totalTryCount = readInput().toInt()

        val racingGame = RacingGame(racingCarNameList.size, totalTryCount)

        racingCarNameList.forEach {
            racingGame.addRacingCar(it)
        }

        racingGame.nextStepAll()

        println()

        resultView.printRacingGameResult(racingGame)
    }
}
