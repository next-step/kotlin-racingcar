package step3.config

import step3.controller.RacingGameController
import step3.domain.car.container.RacingCarContainer
import step3.domain.game.RacingGame
import step3.domain.game.history.RacingGameHistoryContainer
import step3.infra.io.RacingGameInputReader
import step3.infra.random.DefaultRandomGenerator
import step3.infra.random.RandomGenerator
import step3.view.input.InputView
import step3.view.input.impl.InputViewWithCarCountImpl
import step3.view.result.DefaultResultView
import step3.view.result.ResultView
import step3.view.result.history.impl.RacingGameHistoryViewImpl

class RacingGameConfig {
    fun racingGameController(): RacingGameController = RacingGameController(inputView(), resultView(), inputReader())

    fun inputView(): InputView = InputViewWithCarCountImpl()

    fun resultView(): ResultView = DefaultResultView(RacingGameHistoryViewImpl())

    fun inputReader(): RacingGameInputReader = RacingGameInputReader()

    fun racingGame(totalCarCount: Int, totalTryCount: Int): RacingGame =
        RacingGame(
            totalCarCount = totalCarCount,
            totalTryCount = totalTryCount
        )

    fun racingCarContainer(totalCarCount: Int) = RacingCarContainer(totalCarCount)

    fun racingGameHistoryContainer() = RacingGameHistoryContainer()

    fun randomGenerator(): RandomGenerator<Int> = DefaultRandomGenerator
}
