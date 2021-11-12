package racingcar.domain.racing

import racingcar.domain.engine.Engine

data class Racing(private val engine: Engine) {
    fun race(racingDistance: RacingDistance): RacingDistance {
        if (isEnableMove()) {
            return racingDistance.increase()
        }

        return racingDistance
    }

    private fun isEnableMove() = MOVE_CRITERION <= engine.cylinder()

    companion object {
        private const val MOVE_CRITERION = 4
    }
}
