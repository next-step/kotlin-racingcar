package step3.racingcar.domain.cars

import step3.racingcar.domain.status.MovingStatus.MOVE_ONE_STEP_FORWARD
import step3.racingcar.domain.engine.Engine

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
