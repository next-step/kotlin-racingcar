package racingcar.domain.racing

import racingcar.domain.engine.Engine

class Racing {
    fun race(
        racingDistance: RacingDistance,
        engine: Engine
    ): RacingDistance {
        if (isEnableMove(engine)) {
            return racingDistance.increase()
        }

        return racingDistance
    }

    private fun isEnableMove(engine: Engine) = MOVE_CRITERION <= engine.cylinder()

    companion object {
        private const val MOVE_CRITERION = 4
    }
}
