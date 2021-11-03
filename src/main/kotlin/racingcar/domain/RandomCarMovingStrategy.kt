package racingcar.domain

object RandomCarMovingStrategy : MovingStrategy {

    private const val MOVE_CONDITION_NUMBER = 4
    private const val START_RANDOM_NUMBER = 0
    private const val END_RANDOM_NUMBER = 9

    override fun movable(): Boolean {
        return MOVE_CONDITION_NUMBER <= randomNumber()
    }

    private fun randomNumber(): Int {
        return (START_RANDOM_NUMBER..END_RANDOM_NUMBER).random()
    }
}
