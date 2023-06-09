package racing.config

import racing.application.RacingService
import racing.domain.strategy.Generator
import racing.domain.strategy.MoveStrategy
import racing.domain.strategy.RandomNumberGenerator
import racing.domain.strategy.ThresholdBasedMoveStrategy
import racing.ui.RacingController
import racing.ui.RacingInput
import racing.ui.RacingOutput

object RacingConfig {

    val racingController by lazy {
        RacingController(
            racingService = racingService,
            racingInput = racingInput,
            racingOutput = racingOutput
        )
    }
    val racingOutput: RacingOutput by lazy { RacingOutput }
    val racingInput: RacingInput by lazy { RacingInput }
    val racingService: RacingService by lazy { RacingService(moveStrategy = moveStrategy) }
    val moveStrategy: MoveStrategy by lazy { ThresholdBasedMoveStrategy(numberGenerator = generator) }
    val generator: Generator<Int> by lazy { RandomNumberGenerator }
}
