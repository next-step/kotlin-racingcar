package step3.controller

import step3.domain.RacingGame
import step3.infra.RacingGameInputReader
import step3.infra.impl.DefaultRacingGameInputReader
import step3.view.input.DefaultInputView
import step3.view.input.InputView
import step3.view.result.DefaultResultView
import step3.view.result.ResultView
import step3.view.result.history.impl.RacingGameHistoryWithCarNameViewImpl

class RacingGameWithNameController(
    private val inputView: InputView = DefaultInputView(),
    private val resultView: ResultView = DefaultResultView(racingGameHistoryView = RacingGameHistoryWithCarNameViewImpl()),
    private val inputReader: RacingGameInputReader = DefaultRacingGameInputReader()
) : RacingGameInputReader by inputReader {
    fun run() {
        // 1. RacingCarList Input Prompt
        inputView.printInputViewForTotalCarCount()
        val racingCarNameList = readInput().trim().split(",")

        // 2. totalTryCount Input Prompt
        inputView.printInputViewForTotalTryCount()
        val totalTryCount = readInput().toInt()

        // 3. RacingGame init
        val racingGame = RacingGame(racingCarNameList.size, totalTryCount)

        // 4. Add all racingCar with input car names
        racingCarNameList.forEach {
            racingGame.addRacingCar(it)
        }

        // 5. All steps process
        racingGame.nextStepAll()

        // 6. Print new line after racing game completed
        println()

        // 7. Print RacingGameResult
        resultView.printRacingGameResult(racingGame)
    }
}
