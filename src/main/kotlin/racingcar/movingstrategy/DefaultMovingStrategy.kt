package racingcar.movingstrategy

import racingcar.numbergenerator.NumberGenerator
import racingcar.numbergenerator.RandomNumberGenerator

class DefaultMovingStrategy(private val numberGenerator: NumberGenerator = RandomNumberGenerator()) : MovingStrategy {
    override fun isMovable(): Boolean {
        return numberGenerator.get() >= BASELINE_VALUE
    }

    companion object {
        private const val BASELINE_VALUE = 4
    }
}
