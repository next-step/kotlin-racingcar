package racing.domain.strategy

class ThresholdBasedMoveStrategy(private val numberGenerator: Generator<Int>) : MoveStrategy {

    override fun movable(): Boolean = numberGenerator.generate() >= THRESHOLD

    companion object {
        private const val THRESHOLD = 4
    }
}
