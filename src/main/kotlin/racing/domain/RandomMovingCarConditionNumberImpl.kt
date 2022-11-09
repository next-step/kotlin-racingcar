package racing.domain

class RandomMovingCarConditionNumberImpl : RandomMovingCarConditionNumber {

    override fun random(): Int = DEFAULT_MOVING_CAR_CONDITION_RANGE.random()

    companion object {
        private val DEFAULT_MOVING_CAR_CONDITION_RANGE = 0..9
    }
}
