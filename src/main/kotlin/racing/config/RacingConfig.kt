package racing.config

import racing.application.RacingService
import racing.domain.strategy.Generator
import racing.domain.strategy.MovableStrategy
import racing.domain.strategy.RandomNumberGenerator
import racing.domain.strategy.ThresholdBasedMovableStrategy
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
    val racingService: RacingService by lazy { RacingService(movableStrategy = movableStrategy) }
    val movableStrategy: MovableStrategy by lazy { ThresholdBasedMovableStrategy(numberGenerator = generator) }
    val generator: Generator<Int> by lazy { RandomNumberGenerator }
}
