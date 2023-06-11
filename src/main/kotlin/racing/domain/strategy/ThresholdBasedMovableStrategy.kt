package racing.domain.strategy

import racing.domain.DirectionType

class ThresholdBasedMovableStrategy(private val numberGenerator: Generator<Int>) : Navigator {

    override fun navigate(): DirectionType =
        if (numberGenerator.generate() >= THRESHOLD) DirectionType.STRAIGHT else DirectionType.STOP

    companion object {
        private const val THRESHOLD = 4
    }
}
