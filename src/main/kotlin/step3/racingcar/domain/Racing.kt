package step3.racingcar.domain

import step3.racingcar.domain.MovingStatus.MOVE_ONE_STEP_FORWARD

data class Racing(private val engine: Engine) {
    fun race(position: Position): Position {
        if (this.engine.generateCriterionValueToRace() >= MOVE_CRITERION) {
            return Position(position.value + MOVE_ONE_STEP_FORWARD)
        }

        return position
    }

    companion object {
        private const val MOVE_CRITERION = 4
    }
}
