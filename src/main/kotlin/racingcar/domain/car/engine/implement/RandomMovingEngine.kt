package racingcar.domain.car.engine.implement

import racingcar.domain.car.Position
import racingcar.domain.car.engine.MovingEngine
import kotlin.random.Random

/**
 * 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
 */
class RandomMovingEngine : MovingEngine {

    override fun move(position: Position): Position = if (checkRandomCondition()) position.forward() else position

    private fun checkRandomCondition(): Boolean {
        val randomNumber = Random.nextInt(RANDOM_FORM_NUMBER, RANDOM_TO_NUMBER)
        return randomNumber >= MOVING_MINIMUM_CONDITION_NUMBER
    }

    private companion object {
        private const val MOVING_MINIMUM_CONDITION_NUMBER = 4
        private const val RANDOM_FORM_NUMBER = 0
        private const val RANDOM_TO_NUMBER = 9
    }
}
