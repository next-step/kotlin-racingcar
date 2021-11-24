package racingcar.domain.racing

import racingcar.domain.engine.Engine

class RacingDistance(
    val value: Int = START_DISTANCE
) {
    init {
        require(START_DISTANCE <= value)
    }

    fun race(engine: Engine): RacingDistance {
        val next = if (isEnableRace(engine)) RACE_ONE_STEP_FORWARD else STOP
        return RacingDistance(value + next)
    }

    fun isEnableRace(engine: Engine) = RACE_CRITERION <= engine.cylinder()

    companion object {
        private const val START_DISTANCE = 0
        private const val RACE_ONE_STEP_FORWARD = 1
        private const val STOP = 0
        private const val RACE_CRITERION = 4
    }
}
