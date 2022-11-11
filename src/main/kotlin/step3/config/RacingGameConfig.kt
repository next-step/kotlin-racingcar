package step3.config

import step3.controller.RacingGameController
import step3.domain.RacingGame
import step3.domain.car.container.DefaultRacingCarContainer
import step3.domain.car.container.RacingCarContainer
import step3.domain.game.history.DefaultRacingGameHistoryContainer
import step3.domain.game.history.RacingGameHistoryContainer
import step3.infra.io.RacingGameInputReader
import step3.infra.io.impl.RacingGameWithCarCountInputReader
import step3.infra.random.DefaultRandomGenerator
import step3.infra.random.RandomGenerator
import step3.view.input.InputView
import step3.view.input.impl.InputViewWithCarCountImpl
import step3.view.result.DefaultResultView
import step3.view.result.ResultView
import step3.view.result.history.impl.RacingGameHistoryViewImpl

class RacingGameConfig {
    fun racingGameController(): RacingGameController = RacingGameController(inputView(), resultView(), inputReader(), this)

    fun inputView(): InputView = InputViewWithCarCountImpl()

    fun resultView(): ResultView = DefaultResultView(RacingGameHistoryViewImpl())

    fun inputReader(): RacingGameInputReader = RacingGameWithCarCountInputReader()

    fun racingGame(totalCarCount: Int, totalTryCount: Int): RacingGame =
        RacingGame(
            totalCarCount = totalCarCount,
            totalTryCount = totalTryCount,
            racingCarContainer = racingCarContainer(totalCarCount),
            racingGameHistoryContainer = racingGameHistoryContainer(),
            randomGenerator = randomGenerator()
        )

    fun racingCarContainer(totalCarCount: Int): RacingCarContainer = DefaultRacingCarContainer(totalCarCount)

    fun racingGameHistoryContainer(): RacingGameHistoryContainer = DefaultRacingGameHistoryContainer()

    fun randomGenerator(): RandomGenerator<Int> = DefaultRandomGenerator
}
