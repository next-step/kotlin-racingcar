package racingcar.domain.strategy

class RandomMovableStrategy : MovableStrategy {
    override fun move(): Boolean {
        return RANDOM_NUMBER_RANGE.random() >= MOVABLE_CONDITION_NUMBER
    }

    companion object {
        const val MOVABLE_CONDITION_NUMBER = 4
        private val RANDOM_NUMBER_RANGE = 0..9
    }
}
