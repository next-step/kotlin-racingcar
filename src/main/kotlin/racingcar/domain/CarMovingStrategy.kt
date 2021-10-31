package racingcar.domain

class CarMovingStrategy : MovingStrategy {

    override fun movable(): Boolean {
        return MOVE_CONDITION_NUMBER <= randomNumber()
    }

    private fun randomNumber(): Int {
        return (START_RANDOM_NUMBER..END_RANDOM_NUMBER).random()
    }

    companion object {
        private const val MOVE_CONDITION_NUMBER = 4
        private const val START_RANDOM_NUMBER = 0
        private const val END_RANDOM_NUMBER = 9
    }
}
