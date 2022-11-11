package step3.controller

import step3.config.RacingGameConfig
import step3.infra.io.RacingGameInputReader
import step3.infra.io.impl.RacingGameWithCarCountInputReader
import step3.view.input.InputView
import step3.view.input.impl.InputViewWithCarCountImpl
import step3.view.result.DefaultResultView
import step3.view.result.ResultView
import step3.view.result.history.impl.RacingGameHistoryViewImpl

class RacingGameController(
    private val inputView: InputView = InputViewWithCarCountImpl(),
    private val resultView: ResultView = DefaultResultView(
        racingGameHistoryView = RacingGameHistoryViewImpl()
    ),
    private val inputReader: RacingGameInputReader = RacingGameWithCarCountInputReader(),
    private val config: RacingGameConfig = RacingGameConfig()
) : RacingGameInputReader by inputReader {
    fun run() {
        // 1. totalCarCount Input Prompt
        inputView.printInputViewForTotalCarCount()
        val carNameList = readInputForTotalCarNameList()
        val totalCarCount = carNameList.size

        // 2. totalTryCount Input Prompt
        inputView.printInputViewForTotalTryCount()
        val totalTryCount = readInput().toInt()

        // 3. RacingGame init
        val racingGame = config.racingGame(totalCarCount, totalTryCount)

        // 4. Add all racingCar (#totalCarCount)
        carNameList.forEach { racingGame.addRacingCar(it) }

        // 5. All steps process
        racingGame.nextStepAll()

        // 6. Print new line after racing game completed
        println()

        // 7. Print RacingGameResult
        resultView.printRacingGameResult(racingGame)
    }
}
