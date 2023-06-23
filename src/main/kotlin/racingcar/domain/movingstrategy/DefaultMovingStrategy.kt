package racingcar.domain.movingstrategy

import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.domain.numbergenerator.RandomNumberGenerator

class DefaultMovingStrategy(private val numberGenerator: NumberGenerator = RandomNumberGenerator()) : MovingStrategy {
    override fun isMovable(): Boolean {
        return numberGenerator.get() >= BASELINE_VALUE
    }

    companion object {
        private const val BASELINE_VALUE = 4
    }
}
