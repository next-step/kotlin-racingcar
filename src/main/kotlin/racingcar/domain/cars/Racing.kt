package racingcar.domain.cars

import racingcar.domain.engine.Engine

data class Racing(private val engine: Engine) {
    fun race(racingLab: RacingLab): RacingLab {
        if (isEnableMove()) {
            return RacingLab(racingLab.value + MOVE_ONE_STEP_FORWARD)
        }

        return racingLab
    }

    private fun isEnableMove() = MOVE_CRITERION <= engine.generateCriterionValueToRace()

    companion object {
        private const val MOVE_CRITERION = 4
        private const val MOVE_ONE_STEP_FORWARD = 1
    }
}
